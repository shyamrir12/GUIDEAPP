package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.CartData;
import com.example.user3.guideapp.Model.Result;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class CartActivity extends AppCompatActivity {

    String courseid;
    TextView textviewInstructorName, textviewCourseName, textviewDescription, textviewweekno, textviewSD, textviewED, textViewCheckout,textViewPrice;
    RadioButton radioongoing, radioupcommang;
    LinearLayout linerLayoutdates, linerLayoutduration;
    ProgressDialog progressDialog;
    String UpcomingBatchSD,UpcomingBatchED,OngoingBatchSD,OngoingBatchED,startdate;
    String wvt="false";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        courseid = getIntent().getStringExtra("courseid");
        textviewInstructorName = findViewById(R.id.textviewInstructorName);
        textviewCourseName = findViewById(R.id.textviewCourseName);
        textviewDescription = findViewById(R.id.textviewDescription);
        textviewweekno = findViewById(R.id.textviewweekno);
        textviewSD = findViewById(R.id.textviewSD);
        textviewED = findViewById(R.id.textviewED);
        textViewCheckout = findViewById(R.id.textViewCheckout);
        radioongoing = findViewById(R.id.radioongoing);
        radioupcommang = findViewById(R.id.radioupcommang);
        linerLayoutdates = findViewById(R.id.linerLayoutdates);
        linerLayoutduration = findViewById(R.id.linerLayoutduration);
        textViewPrice=findViewById(R.id.textViewPrice);
        progressDialog = new ProgressDialog(this);

        getCart();

        //textViewCourseId=findViewById(R.id.textViewCourseId);
        //textViewCourseId.setText(courseid);
    }

    public void getCart() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new CartActivity.GETCart().execute(SharedPrefManager.getInstance(this).getUser().access_token, courseid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class GETCart extends AsyncTask<String, Void, String> {
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
                builder.url(PlayerConfig.BASE_URL_API + "LearnerApi/Cartget/" + courseid);
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
                Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            }


            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
                CartData.RootObject jsonbodys = gson.fromJson(result, CartData.RootObject.class);

                UpcomingBatchSD=jsonbodys.getUpcomingBatchSD();
                        UpcomingBatchED=jsonbodys.getUpcomingBatchED();
                OngoingBatchSD=jsonbodys.getOngoingBatchSD();
                        OngoingBatchED=jsonbodys.getOngoingBatchED();
                textviewInstructorName.setText(jsonbodys.datacourseDetails.getInstructorName());
                textviewCourseName.setText(jsonbodys.datacourseDetails.getCourseName());
                textviewDescription.setText(jsonbodys.datacourseDetails.getCourseDescription());
                textViewPrice.setText("INR "+String.valueOf(jsonbodys.datacourseDetails.getCoursePrice()));
                if (jsonbodys.getLectureType()!= null&&jsonbodys.getLectureType().equals("WeekWise")) {

                    textviewweekno.setText(jsonbodys.getDuration()+" Weeks");
                    if (jsonbodys.getOngoingBatch().isEmpty()) {
                        radioongoing.setVisibility(View.GONE);
                        textviewSD.setText(jsonbodys.getUpcomingBatchSD());
                        textviewED.setText(jsonbodys.getUpcomingBatchED());
                        radioupcommang.setText(jsonbodys.getUpcomingBatch());
                    } else {
                        textviewSD.setText(jsonbodys.getOngoingBatchSD());
                        textviewED.setText(jsonbodys.getOngoingBatchED());
                        radioongoing.setText(jsonbodys.getOngoingBatch());
                        radioupcommang.setText(jsonbodys.getUpcomingBatch());
                    }


                } else {
                    wvt="true";
                    linerLayoutdates.setVisibility(View.GONE);
                    linerLayoutduration.setVisibility(View.GONE);
                    radioongoing.setVisibility(View.GONE);
                    radioupcommang.setVisibility(View.GONE);
                }
                radioongoing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textviewSD.setText(OngoingBatchSD);
                        textviewED.setText(OngoingBatchED);

                    }
                });
                radioupcommang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textviewSD.setText(UpcomingBatchSD);
                        textviewED.setText(UpcomingBatchED);

                    }
                });
                textViewCheckout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                           startdate=textviewSD.getText().toString();
                        SaveCart();

                    }
                });

                progressDialog.dismiss();
            }


        }
    }


    public void SaveCart() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();

            new CartActivity.POSTCart().execute(SharedPrefManager.getInstance(this).getUser().access_token, courseid,startdate,wvt);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class POSTCart extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];
            String cid = params[1];
            String sd = params[2];
            String wvtt = params[3];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                if(wvtt.equals("true"))
                    builder.url(PlayerConfig.BASE_URL_API+"LearnerApi/Cartpost/"+cid+"/test" );
                else
                    builder.url(PlayerConfig.BASE_URL_API+"LearnerApi/Cartpost/"+cid+"/test/"+sd );
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer " + accesstoken);

                FormBody.Builder parameters = new FormBody.Builder();
                // parameters.add("Reply", replytext);
                // parameters.add("CommentID",String.valueOf( commentid));
                // parameters.add("UserId",String.valueOf( learnerid));

                builder.post(parameters.build());


                okhttp3.Response response = client.newCall(builder.build()).execute();

                if (response.isSuccessful()) {
                    json = response.body().string();


                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(CartActivity.this, "Error: " + e, Toast.LENGTH_SHORT).show();
            }
            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(CartActivity.this, "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
                final Result jsonbodyres = gson.fromJson(result, Result.class);
                Toast.makeText(CartActivity.this, jsonbodyres.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                if (jsonbodyres.getStatus() == false) {
                    //back to course list
                    if(jsonbodyres.getMessage().equals("Succeeded")) {
                        Toast.makeText(CartActivity.this, "course subscribe successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CartActivity.this, MyCourse.class);
                        CartActivity.this.startActivity(intent);
                    }
                    else {

                        //payment getwe messge is gatwe url

                    }
                }
                else
                {
                    Toast.makeText(CartActivity.this, jsonbodyres.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }


        }

    }
}
