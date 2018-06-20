package com.example.user3.guideapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.user3.guideapp.Adapters.FaqAdapter;
import com.example.user3.guideapp.Adapters.PagerAdapter;
import com.example.user3.guideapp.Adapters.WeekAdapter;
import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Fragments.Fragment_Comment;
import com.example.user3.guideapp.Fragments.Fragment_Faq;
import com.example.user3.guideapp.Fragments.Fragment_Lecture;
import com.example.user3.guideapp.Fragments.Fragment_Testimonial;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.Model.Result;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class Course_Details_Tab extends AppCompatActivity  {

   //android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    ProgressDialog progressDialog;
    WeekAdapter weekAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    RecyclerView recyclerViewfaq;
    HashMap<String, List<String>> listDataChild;
    TextView textCourseTitle,textViewCoursedesc;
    ImageView bannerimage;
    List<CourseData.DataCourseFaq> faqList;
    List<CourseData.DatacourseTestimonial> testimonialList;
    FaqAdapter adapterfaq;
    String courseid;
    String courseDescription;
    AlertDialog.Builder builder;
    public boolean getMsg() {
        return msg;
    }

    boolean msg;
    Button buttonSubmitReview,bsubscribe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__details__tab);


       //toolbar=findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        bannerimage=findViewById(R.id.imageViewBanner);
        textCourseTitle = findViewById(R.id.textViewTitle);
        progressDialog = new ProgressDialog(this);
        courseid=getIntent().getStringExtra("courseid");
        bsubscribe=findViewById(R.id.bsubscribe);
        getMyCourseDesc();
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirmation");

        builder.setMessage("Are you sure you want to Unsubscribe this Course?");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        updateUnsubscribe();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // finish();
            }
        });





    }
    public ArrayList gettimonialList()
    {
        return (ArrayList) testimonialList;
    }
    public ArrayList getfaqList()
    {
        return (ArrayList) faqList;
    }
    public ArrayList getHeaderList()
    {
        return (ArrayList) listDataHeader;
    }
    public HashMap<String, List<String>> getChildList()
    {
        return (HashMap<String, List<String>>) listDataChild;
    }

    public String getCourseid() {
        return courseid;
    }
    public String getCourseDescription() {
        return courseDescription;
    }

    public void getMyCourseDesc() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new Course_Details_Tab.GETCourseDesc().execute(SharedPrefManager.getInstance(this).getUser().access_token,courseid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
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
                builder.url(PlayerConfig.BASE_URL_API+"InstructorApi/GetCourseDetails/"+courseid);
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
                String imgurl="";
                CourseData.RootObject jsonbodys = gson.fromJson(result, CourseData.RootObject.class);

                CourseData.Datacoursedetails cd=jsonbodys.datacoursedetails;
                CourseData.Datacoursebanner cb=jsonbodys.datacoursebanner;
                List<CourseData.Datacoursecontent> cc=jsonbodys.datacoursecontent;
                List<CourseData.Dataweek > dw=jsonbodys.dataweek;
                List<CourseData.Datatopic > dt=jsonbodys.datatopic;
                msg=jsonbodys.status;
               textCourseTitle.setText( cd.getCourseName());
               courseDescription= cd.getCourseDescription();


                if(cb!=null)
                    imgurl=PlayerConfig.BASE_URL_API_BLOB+cd.getCourseID().toLowerCase()+"/"+cb.getFileId()+"/"+cb.getFileName().replace(' ','_').toLowerCase();
                else
                    imgurl="https://www.homesbykimblanton.com/uploads/shared/images/library%202.jpg";


                Picasso.with(Course_Details_Tab.this).load(imgurl).into(bannerimage);
                listDataHeader = new ArrayList<String>();
                listDataChild = new HashMap<String, List<String>>();

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < dw.size(); i++) {

                    listDataHeader.add(dw.get(i).getWeekName());

                    List<String>  wn  = new ArrayList<String>();
                    for(int j = 0; j < dt.size(); j++)
                    {
                        if(dt.get(j).getWeekID()==dw.get(i).getWeekID()) {
                            for(int k=0;k<cc.size();k++){
                                if(dt.get(j).getTopicID()==cc.get(k).getTopicID()){
                                    String contentid=Integer.toString( cc.get(k).getContentID());
                                    String lecture=dt.get(j).getTopicName()+":"+cc.get(k).getContentTitle()+","+contentid;

                                    wn.add(lecture);

                                }
                            }
                        }
                    }
                    listDataChild.put( dw.get(i).getWeekName(), wn);
                    //System.out.println("Weekname:"+ weeks[i]);
                }


                faqList=new ArrayList<>();
                faqList=jsonbodys.dataCourseFaq;
                testimonialList=new ArrayList<>();
                testimonialList=jsonbodys.datacourseTestimonial;
                //for tab
                tabLayout=findViewById(R.id.tablayout);
                viewPager=findViewById(R.id.pager);
                pagerAdapter=new PagerAdapter(getSupportFragmentManager());
                pagerAdapter.addFragment(new Fragment_Comment(),"Details");
                pagerAdapter.addFragment(new Fragment_Lecture(),"Lecture");
                pagerAdapter.addFragment(new Fragment_Faq(),"Faq");
                pagerAdapter.addFragment(new Fragment_Testimonial(),"Testimonial");
                viewPager.setAdapter(pagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

                 if(jsonbodys.status==true)
                { bsubscribe.setText("Unsubscribe");

                    bsubscribe.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                AlertDialog dialog = builder.create();
                                dialog.show();
                                //bsubscribe.setText("Unsubscribe");

                        }

                    });


                }
                else { bsubscribe.setText("Subscribe");
                     bsubscribe.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                            if(SharedPrefManager.getInstance(Course_Details_Tab.this).getUser().access_token.equals(""))
                            {
                                Intent intent=new Intent(Course_Details_Tab.this, Register.class);
                                intent.putExtra("courseid",courseid);
                                Course_Details_Tab.this.startActivity(intent);
                            }
                            else
                            {
                                //go to cart
                                Intent intent=new Intent(Course_Details_Tab.this,CartActivity.class);
                                intent.putExtra("courseid",courseid);
                                Course_Details_Tab.this.startActivity(intent);

                            }


                         }

                     });}

                progressDialog.dismiss();

            }


        }
    }


    public void updateUnsubscribe() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();

            new Course_Details_Tab.PUTUnsubscribe().execute(SharedPrefManager.getInstance(this).getUser().access_token, courseid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class PUTUnsubscribe extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];
            String cid = params[1];


            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API+"LearnerApi/CourseUnSubscribeput/"+cid );
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer " + accesstoken);

                FormBody.Builder parameters = new FormBody.Builder();
               // parameters.add("Reply", replytext);
               // parameters.add("CommentID",String.valueOf( commentid));
               // parameters.add("UserId",String.valueOf( learnerid));

                builder.put(parameters.build());


                okhttp3.Response response = client.newCall(builder.build()).execute();

                if (response.isSuccessful()) {
                    json = response.body().string();


                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(Course_Details_Tab.this, "Error: " + e, Toast.LENGTH_SHORT).show();
            }
            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(Course_Details_Tab.this, "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
                final Result jsonbodyres = gson.fromJson(result, Result.class);
                Toast.makeText(Course_Details_Tab.this, jsonbodyres.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                if (jsonbodyres.getStatus() == false) {
                    //back to course list
                    Toast.makeText(Course_Details_Tab.this, "course unsubscribe successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Course_Details_Tab.this, MyCourse.class);
                    Course_Details_Tab.this.startActivity(intent);
                }
                else
                {
                    Toast.makeText(Course_Details_Tab.this, jsonbodyres.getMessage(), Toast.LENGTH_SHORT).show();

                }


            }


        }

    }

}
