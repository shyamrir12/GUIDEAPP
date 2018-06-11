package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.TrackingData;
import com.google.gson.Gson;

import java.text.DecimalFormat;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Course_Tracking extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView,textViewcoursename,textViewSample;
   String courseid,coursename,percentage;
    ProgressDialog progressDialog;
    DecimalFormat df2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__tracking);
        progressBar = findViewById (R.id.circularProgressBar);
        progressDialog = new ProgressDialog(this);
        courseid=getIntent().getStringExtra("courseid");
        textView=  findViewById(R.id.textView1);
        textViewcoursename=findViewById(R.id.textViewCourseName);
        textViewSample=findViewById(R.id.textViewSample);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // CourseAdapter ca=new CourseAdapter();
        //courseid=ca.getCourseid();
        getCourseTracking();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void getCourseTracking() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new Course_Tracking.GETTracking().execute(SharedPrefManager.getInstance(this).getUser().access_token,courseid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }
    private class GETTracking extends AsyncTask<String, Void, String> {
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
                builder.url(PlayerConfig.BASE_URL_API+"LearnerApi/CourseTracking/"+courseid+"/x");
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
                Toast.makeText(Course_Tracking.this, "Error: " + e, Toast.LENGTH_SHORT).show();
            }


            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(Course_Tracking.this, "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
               TrackingData.RootObject jsonbodys = gson.fromJson(result, TrackingData.RootObject.class);
               // df2 = new DecimalFormat(".##");
               // percentage=df2.format(jsonbodys.getPercent());
                 percentage=String.valueOf((int)jsonbodys.getPercent());
                //System.out.println(percentage);
                progressBar.setProgress((int) jsonbodys.getPercent());
                // as 60 is max, we specified in the xml layout, 30 will be its half 😉

                textView.setText(percentage+"%");
                textViewcoursename.setText(jsonbodys.getCourseName());
                textViewSample.setText("Your course is "+percentage+"% complete");
                progressDialog.dismiss();

            }


        }
    }
}
