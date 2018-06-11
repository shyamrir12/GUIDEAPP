package com.example.user3.guideapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user3.guideapp.Adapters.CourseAdapter;
import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Fragments.Fragment_Testimonial;
import com.example.user3.guideapp.Fragments.Fragment_Tracking;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.HomeData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyCourse extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog ;

    List<HomeData.CourseApiList> courseapiList;
    CourseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_course);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //listView = findViewById(R.id.listViewMycourse);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        getMyCourse();

        //setting adapter to recyclerview

    }
    public void loadFragment() {
        FragmentManager fm = getFragmentManager();
        Fragment_Tracking  ftr=new Fragment_Tracking();
        ftr.show(fm,"Fragment");
    }
    public void getMyCourse()
    {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new MyCourse.GETCourseList().execute(SharedPrefManager.getInstance(this).getUser().access_token);

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
            //String clave = params[1];
            //String res = params[2];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API+"InstructorApi/GetMyCourse");
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

                    //Week jsonbody = gson.fromJson(json,Week.class);
                    //SharedPrefManager.getInstance(getApplicationContext()).userLogin(jsonbody);

                    //System.out.println(jsonbody.userName+":"+ jsonbody.access_token);
                    //res=json;
                    //System.out.println("CONTENIDO::  " + json);
                    //Toast.makeText(getApplicationContext(),json,Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(getApplicationContext(),"Error: " + e,Toast.LENGTH_SHORT).show();
            }


            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                //progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Invalid request", Toast.LENGTH_SHORT).show();
            } else {

                //System.out.println(result);
                Gson gson = new Gson();

                //to convert strong responce in to list
                /*Type listType = new TypeToken<List<Week>>(){}.getType();
                List<Week> jsonbody = new Gson().fromJson(result, listType);

                String[] weeks = new String[jsonbody.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < jsonbody.size(); i++) {
                    weeks[i] = jsonbody.get(i).getWeekName();
                    //System.out.println("Weekname:"+ weeks[i]);
                }


                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, weeks));
              */


                HomeData.HomeDataResult jsonbody = gson.fromJson(result, HomeData.HomeDataResult.class);
               // HomeData.DataCourseBanner jsonbodybanner=gson.fromJson(result,HomeData.DataCourseBanner.class);
                //HomeData.DataRating jsonbodyrating=gson.fromJson(result,HomeData.DataRating.class);
                 //System.out.println("Message: " +jsonbody.dataCourse.get(1).getCourseName());

                  //courseapiList=new ArrayList<>();

                //courseapiList=jsonbody.courseapilist;

                List<HomeData.DataCourse> courselist =jsonbody.dataCourse;
                List<HomeData.DataCourseBanner> bannerlist =jsonbody.dataCourseBanner;
                List<HomeData.DataRating> ratinglist =jsonbody.dataRating;

                for (HomeData.DataCourse c : courselist){

                    for (HomeData.DataCourseBanner b : bannerlist){
                        if (b.getCourseID().equals(c.getCourseID())) {
                            c.setFileId(b.getFileId());
                            c.setFileName(b.getFileName());
                        }


                    }
                    for (HomeData.DataRating r : ratinglist){
                        if (r.getCourseID().equals(c.getCourseID()))
                            c.setAvrageRating(r.getAvrageRating());

                    }

                }

                adapter = new CourseAdapter(MyCourse.this, courselist);
                recyclerView.setAdapter(adapter);
                //creating recyclerview adapter

                //List<HomeData.HomeDataResult>=new ArrayList<HomeData.HomeDataResult>();

                //jsonbody.dataCourse courseList= new ArrayList<>();



               // String[] course = new String[jsonbody.dataCourse.size()];

                //looping through all the heroes and inserting the names inside the string array
              //  for (int i = 0; i < jsonbody.dataCourse.size(); i++) {
               //     course[i] = jsonbody.dataCourse.get(i).getCourseName();
                //}


                //displaying the string array into listview
                //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, course));

                progressDialog.dismiss();
                // Toast.makeText(getApplicationContext(),jsonbody.Message,Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.INVISIBLE);
                // progressDialog.dismiss();
                //Intent log = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(log);
            }
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();


        }
    }
}
