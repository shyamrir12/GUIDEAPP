package com.example.user3.guideapp.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.user3.guideapp.Adapters.CommentAdapter;
import com.example.user3.guideapp.Adapters.ReplyAdapter;
import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.Model.Result;
import com.example.user3.guideapp.R;
import com.example.user3.guideapp.Reply;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Fragment_Reply extends Fragment {
    View view;
    Button firstButtonreply;
    List<CourseData.Datareply> replyList;
    EditText editTextReply;

    RecyclerView recyclerViewReply;
   ReplyAdapter replyAdapters;
    ProgressDialog progressDialog;
    String courseid, commentid,learnerid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       Reply  ra = (Reply) getActivity();

        //testimonialList=new ArrayList<>();
        // set title
        // getDialog().setTitle("Add Testimonial");
        courseid = ra.getCourseid();
        commentid=ra.getCommentid();
        progressDialog = new ProgressDialog(getActivity());
        getMyCourseDesc();
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.layout_reply, container, false);
        // get the reference of Button


        firstButtonreply = (Button) view.findViewById(R.id.firstButtonreply);
        editTextReply=(EditText)view.findViewById(R.id.edittextReply);
        // perform setOnClickListener on first Button
        firstButtonreply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                //Toast.makeText(getActivity(), "First Fragment :", Toast.LENGTH_LONG).show();
                saveReply();


            }
        });
        return view;
    }

    public void getMyCourseDesc() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new Fragment_Reply.GETCourseDesc().execute(SharedPrefManager.getInstance(getActivity()).getUser().access_token, courseid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getActivity(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class GETCourseDesc extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];
            String courseid = params[1];
            //String res = params[2];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url("http://guidedev.azurewebsites.net/api/InstructorApi/GetCourseDetails/" + courseid);
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer " + accesstoken);

               /* FormBody.Builder parameters = new FormBody.Builder();
                parameters.add("grant_type", "password");
                parameters.add("username", cliente);
                parameters.add("password", clave);
                builder.post(parameters.build());
                */
                okhttp3.Response response = client.newCall(builder.build()).execute();

                if (response.isSuccessful()) {
                    json = response.body().string();


                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(getActivity(), "Error: " + e, Toast.LENGTH_SHORT).show();
            }


            return json;
        }




        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
                CourseData.RootObject jsonbodys = gson.fromJson(result, CourseData.RootObject.class);
               replyList = new ArrayList<>();
                replyList = jsonbodys.datareply;


                List<CourseData.Datareply> newList = new ArrayList<>();
                for (CourseData.Datareply c : replyList){
                    if (c.getCommentId()==Integer.parseInt(commentid)) newList.add(c);
                }

                recyclerViewReply = (RecyclerView) view.findViewById(R.id.recyclerViewReply);

             replyAdapters= new ReplyAdapter(getActivity(), newList);

                recyclerViewReply.setLayoutManager(new LinearLayoutManager(getActivity()));

                recyclerViewReply.setAdapter(replyAdapters);
                learnerid = jsonbodys.getUserId();
                progressDialog.dismiss();

            }


        }
    }

    public void saveReply() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            String replytext =editTextReply.getText().toString();


            new Fragment_Reply.POSTComment().execute(SharedPrefManager.getInstance(getActivity()).getUser().access_token, replytext, courseid, learnerid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getActivity(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class POSTComment extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];


            String replytext = params[1];
            String courseidtext = params[2];
            String learnerid = params[3];

            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url("http://guidedev.azurewebsites.net/api/LearnerApi/CourseTestimonialpost" );
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer" + accesstoken);

                FormBody.Builder parameters = new FormBody.Builder();
                parameters.add("Reply", replytext);
                parameters.add("CourseID", courseidtext);
                parameters.add("LearnerID", learnerid);
                builder.post(parameters.build());


                okhttp3.Response response = client.newCall(builder.build()).execute();

                if (response.isSuccessful()) {
                    json = response.body().string();


                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(getActivity(), "Error: " + e, Toast.LENGTH_SHORT).show();
            }
            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
                final Result jsonbodyres = gson.fromJson(result, Result.class);
                Toast.makeText(getActivity(), jsonbodyres.getMessage(), Toast.LENGTH_SHORT).show();
                if (jsonbodyres.getStatus() == false) {
                    getMyCourseDesc();
                }
                progressDialog.dismiss();

            }


        }

    }
}
