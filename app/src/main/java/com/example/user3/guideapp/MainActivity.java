package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.Adapters.CustomGrid;
import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.Model.HomeIndex;
import com.example.user3.guideapp.Model.RootObject;
import com.example.user3.guideapp.Model.Week;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    GridView grid, gridcat;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ListView listViewCourseList, listViewCategoryList;
    //TextView textemail;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.navigation_drawer);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        //textemail = findViewById(R.id.text_email);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);
        // View header=navigationView.getHeaderView(0);
        /*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        View hView = navigationView.inflateHeaderView(R.layout.navigation_header);


        TextView email = hView.findViewById(R.id.textvieemail);
        //TextView  name =  hView.findViewById(R.id.textviewname);

        email.setText(SharedPrefManager.getInstance(this).getUser().userName);
        // name.setText(SharedPrefManager.getInstance(this).getUser().expires_in);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //listViewCourseList = findViewById(R.id.listViewCourseList);
        // listViewCategoryList=findViewById(R.id.listViewCategoryList);
        //textemail.setText(SharedPrefManager.getInstance(this).getUser().userName);
        getheros();

        //setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_logout:
                // User chose the "Settings" item, show the app settings UI...
                SharedPrefManager.getInstance(this).logout();
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
                //Toast.makeText(this,"logout clicked",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_credits:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(this, "credits clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.home_id:
                Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_profile_id:
                Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_course_id:
                Intent log = new Intent(getApplicationContext(), MyCourse.class);
                startActivity(log);
                //Toast.makeText(this, "Course Clicked", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }


    }

    private void getheros() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new GETWeekList().execute();

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<List<Week>> call = api.getWeeks(SharedPrefManager.getInstance(this).getUser().access_token);
        call.enqueue(new  Callback<List<Week>>() {
            @Override
            public void onResponse(Call<List<Week>> call, Response<List<Week>> response) {
                List<Week> heros=response.body();
               // for(Hero h:heros){
                //    Log.d("name",h.getName());
                //    Log.d("realname",h.getRealname());
                 //   Log.d("imageurl",h.getImageurl());
                //}
                String[] weeks = new String[heros.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heros.size(); i++) {
                    weeks[i] = heros.get(i).getWeekName();
                }


                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, weeks));


            }

            @Override
            public void onFailure(Call<List<Week>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    private class GETWeekList extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream = null;
            //String accesstoken = params[0];
            //String clave = params[1];
            //String res = params[2];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API + "HomeApi/GetIndex");
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                //builder.addHeader("Authorization", "Bearer " + accesstoken);

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
                Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            }


            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                //progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Invalid user id or password", Toast.LENGTH_SHORT).show();
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


                HomeIndex.HomeIndexResult jsonbody = gson.fromJson(result, HomeIndex.HomeIndexResult.class);

                final String[] course = new String[jsonbody.dataCourseList.size()];
                String[] category = new String[jsonbody.dataCategoryList.size()];
                String[] catid = new String[jsonbody.dataCategoryList.size()];
                int[] imageId = new int[jsonbody.dataCourseList.size()];
                String[] courseid = new String[jsonbody.dataCourseList.size()];
                int[] imageIdcat = new int[jsonbody.getDataCategoryList().size()];
                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < jsonbody.dataCourseList.size(); i++) {
                    course[i] = jsonbody.dataCourseList.get(i).getCourseName();
                    imageId[i] = R.drawable.book;
                    courseid[i]=jsonbody.dataCourseList.get(i).getCourseID();
                }

                for (int i = 0; i < jsonbody.dataCategoryList.size(); i++) {
                    category[i] = jsonbody.dataCategoryList.get(i).getCategoryName();
                    imageIdcat[i] = R.drawable.book;
                    catid[i]=String.valueOf(jsonbody.dataCategoryList.get(i).getCategoryID());
                }
                CustomGrid adapter = new CustomGrid(MainActivity.this, course, imageId,courseid);
                grid = (GridView) findViewById(R.id.grid);
                grid.setAdapter(adapter);
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                       // Toast.makeText(getApplicationContext(), ((TextView) v.findViewById(R.id.grid_catid)).getText(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this, Course_Details_Tab.class);
                        intent.putExtra("courseid",((TextView) v.findViewById(R.id.grid_catid)).getText());
                        startActivity(intent);
                    }
                });
                CustomGrid adaptercat = new CustomGrid(MainActivity.this, category, imageIdcat,catid);
                gridcat = (GridView) findViewById(R.id.gridcat);
                gridcat.setAdapter(adaptercat);

                gridcat.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {

                    //    Toast.makeText(MainActivity.this, ((TextView) v.findViewById(R.id.grid_catid)).getText(), Toast.LENGTH_SHORT).show();

                        Intent seemore = new Intent(MainActivity.this,SeeMoreActivity.class);
                        seemore.putExtra("categoryid",((TextView) v.findViewById(R.id.grid_catid)).getText());
                        startActivity(seemore);

                    }
                });
                //displaying the string array into listview
                //listViewCourseList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, course));
                //listViewCategoryList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, category));
                //System.out.println("Error: " +jsonbody.Message);


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
