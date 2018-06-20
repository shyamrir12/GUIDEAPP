package com.example.user3.guideapp.Fragments;

import android.app.DialogFragment;
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
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class Fragment_Testimonial extends android.support.v4.app.Fragment {
    View view;
    Button firstButton, buttonclose;
    List<CourseData.DatacourseTestimonial> testimonialList;
    EditText textViewTestimonial;
    RatingBar ratingBar;
    RecyclerView recyclerViewtestimonial;
    TestimonialAdapters testimonialAdapters;
    ProgressDialog progressDialog;
    String courseid, learnerid;
    boolean msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Course_Details_Tab cd = (Course_Details_Tab) getActivity();
        cd.gettimonialList();
        //testimonialList=new ArrayList<>();
        // set title
        // getDialog().setTitle("Add Testimonial");
        courseid = cd.getCourseid();
        msg= cd.getMsg();
        progressDialog = new ProgressDialog(getActivity());
        getMyCourseDesc();
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_testimonial, container, false);
// get the reference of Button

        textViewTestimonial = (EditText) view.findViewById(R.id.edittextTestimonial);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBarTestimonial);
        firstButton = (Button) view.findViewById(R.id.firstButton);
       // buttonclose = (Button) view.findViewById(R.id.buttonclose);
       /* buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });*/
// perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// display a message by using a Toast
                if(msg==true){ //Toast.makeText(getActivity(), "First Fragment :", Toast.LENGTH_LONG).show();
                saveTestimonial();
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
            new Fragment_Testimonial.GETCourseDesc().execute(SharedPrefManager.getInstance(getActivity()).getUser().access_token, courseid);

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
                testimonialList = new ArrayList<>();
                testimonialList = jsonbodys.datacourseTestimonial;
                recyclerViewtestimonial = (RecyclerView) view.findViewById(R.id.recyclerViewTestimonial);
                testimonialAdapters = new TestimonialAdapters(getActivity(), testimonialList);
                recyclerViewtestimonial.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerViewtestimonial.setAdapter(testimonialAdapters);
                learnerid = jsonbodys.getUserId();
                progressDialog.dismiss();

            }


        }
    }

    public void saveTestimonial() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            String testimonialtext = textViewTestimonial.getText().toString();
            String rating = String.valueOf((int) ratingBar.getRating());


            new Fragment_Testimonial.POSTTestimonial().execute(SharedPrefManager.getInstance(getActivity()).getUser().access_token, rating, testimonialtext, courseid, learnerid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getActivity(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class POSTTestimonial extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];
            String rating = params[1];

            String testimonialtext = params[2];
            String courseidtext = params[3];
            String learnerid = params[4];

            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API+"LearnerApi/CourseTestimonialpost/" + rating);
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer " + accesstoken);

                FormBody.Builder parameters = new FormBody.Builder();
                parameters.add("Testimonial", testimonialtext);
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
