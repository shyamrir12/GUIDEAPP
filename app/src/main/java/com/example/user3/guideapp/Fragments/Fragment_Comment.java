package com.example.user3.guideapp.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.Adapters.CommentAdapter;
import com.example.user3.guideapp.Adapters.TestimonialAdapters;
import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.Course_Details_Tab;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.Model.Result;
import com.example.user3.guideapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Fragment_Comment extends android.support.v4.app.Fragment {
    View view;
    Button firstButton, buttonclose;
    List<CourseData.Dataforum> commentList;
    EditText editTextComment;
    RatingBar ratingBar;
    RecyclerView recyclerViewComment;
    CommentAdapter commentAdapters;
    ProgressDialog progressDialog;
    String courseid, learnerid, courseDescription;
    boolean msg;
    TextView textViewcourseDescription,mytext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Course_Details_Tab cd = (Course_Details_Tab) getActivity();
        //cd.gettimonialList();
        //testimonialList=new ArrayList<>();
        // set title
        // getDialog().setTitle("Add Testimonial");
        courseid = cd.getCourseid();
        msg=cd.getMsg();
        //courseDescription = cd.getCourseDescription();
        progressDialog = new ProgressDialog(getActivity());
        getMyCourseDesc();
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_comment, container, false);
        // get the reference of Button

        textViewcourseDescription = (TextView) view.findViewById(R.id.textViewTitle);
        mytext=(TextView) view.findViewById(R.id.Mytext);
        firstButton = (Button) view.findViewById(R.id.firstButton);
        editTextComment = (EditText) view.findViewById(R.id.edittextComment);
        // perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                //Toast.makeText(getActivity(), "First Fragment :", Toast.LENGTH_LONG).show();
                if(msg=true){
                    saveComment();
            } else {
                Toast.makeText(getActivity(), "Course Not Subscribe by You", Toast.LENGTH_SHORT).show();

            }


            }
        });
        return view;
    }

    public void getMyCourseDesc() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new Fragment_Comment.GETCourseDesc().execute(SharedPrefManager.getInstance(getActivity()).getUser().access_token, courseid);

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
                builder.url(PlayerConfig.BASE_URL_API+"InstructorApi/GetCourseDetails/" + courseid);
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
                courseDescription=jsonbodys.datacoursedetails.getCourseDescription();
                textViewcourseDescription.setText(courseDescription);
                commentList = new ArrayList<>();
                commentList = jsonbodys.dataforum;

                List<CourseData.Datareply> replylist = jsonbodys.datareply;
                for (CourseData.Dataforum c : commentList) {

                    List<CourseData.Datareply> newList = new ArrayList<>();
                    for (CourseData.Datareply d : replylist) {
                        if (d.getCommentId() == c.getCommentId())
                            newList.add(d);

                    }
                    c.setTotalReply(newList.size());
                    // System.out.println("Reply"+String.valueOf(c.getTotalReply()));
                }
                recyclerViewComment = (RecyclerView) view.findViewById(R.id.recyclerViewComment);

                CommentAdapter commentAdapter = new CommentAdapter(getActivity(), commentList);

                recyclerViewComment.setLayoutManager(new LinearLayoutManager(getActivity()));

                recyclerViewComment.setAdapter(commentAdapter);
                learnerid = jsonbodys.getUserId();
                if(msg==true){
                    recyclerViewComment.setVisibility(View.VISIBLE);
                mytext.setVisibility(View.VISIBLE);
                firstButton.setVisibility(View.VISIBLE);
                editTextComment.setVisibility(View.VISIBLE);}
                else {
                    recyclerViewComment.setVisibility(View.GONE); mytext.setVisibility(View.GONE);
                    firstButton.setVisibility(View.GONE);
                    editTextComment.setVisibility(View.GONE);
                }
                progressDialog.dismiss();

            }


        }
    }

    public void saveComment() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            String commenttext = editTextComment.getText().toString();


            new Fragment_Comment.POSTComment().execute(SharedPrefManager.getInstance(getActivity()).getUser().access_token, commenttext, courseid);

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


            String commenttext = params[1];
            String courseidtext = params[2];


            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API+"LearnerApi/PostDiscussionForum");
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer " + accesstoken);

                FormBody.Builder parameters = new FormBody.Builder();
                parameters.add("Comment", commenttext);
                parameters.add("CourseID", courseidtext);
                parameters.add("UserId", String.valueOf(learnerid));
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
