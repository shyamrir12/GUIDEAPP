package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user3.guideapp.Adapters.CourseAdapter;
import com.example.user3.guideapp.Adapters.SeeMoreAdapter;
import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.Model.SeeMoreData;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class SeeMoreActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    ProgressDialog progressDialog ;
  SeeMoreAdapter adapter;
  String categoryid="0";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seemore_layouy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryid=getIntent().getStringExtra("categoryid");

        //listView = findViewById(R.id.listViewMycourse);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(this);
        getCourse();
    }
    public void getCourse()
    {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new SeeMoreActivity.GETCourseList().execute(SharedPrefManager.getInstance(this).getUser().access_token,categoryid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }
    private class GETCourseList extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];
            String catid = params[1];
            //String res = params[2];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API+"HomeApi/SeeMoreget/"+catid);
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
                Toast.makeText(getApplicationContext(),"Error: " + e,Toast.LENGTH_SHORT).show();
            }


            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Invalid request", Toast.LENGTH_SHORT).show();
            } else {


                Gson gson = new Gson();
               SeeMoreData.RootObject jsonbody = gson.fromJson(result,  SeeMoreData.RootObject.class);

                List< SeeMoreData.Datacourselist> courselist =jsonbody.datacourselist;
                List<SeeMoreData.Datacoursebanner> bannerlist =jsonbody.datacoursebanner;
                List<SeeMoreData.Dataavragecourserating> ratinglist =jsonbody.dataavragecourserating;
                List<SeeMoreData.Datalearnersubscription> learnersubscriptionlist =jsonbody.datalearnersubscription;

                for (SeeMoreData.Datacourselist c : courselist){

                    for (SeeMoreData.Datacoursebanner b : bannerlist){
                        if (b.getCourseID().equals(c.getCourseID())) {
                            c.setFileId(b.getFileId());
                            c.setFileName(b.getFileName());
                        }


                    }
                    for (SeeMoreData.Dataavragecourserating r : ratinglist){
                        if (r.getCourseID().equals(c.getCourseID()))
                            c.setAvrageRating(r.getAvrageRating());

                    }
                    if(learnersubscriptionlist!=null){
                    for (SeeMoreData.Datalearnersubscription s : learnersubscriptionlist){
                        if (s.getCourseID().equals(c.getCourseID()))
                            c.setSubscriptionStatus(s.isSubscriptionStatus());

                    }}

                }

               adapter = new SeeMoreAdapter(SeeMoreActivity.this, courselist);
                recyclerView.setAdapter(adapter);
                 progressDialog.dismiss();

            }


        }
    }
}
