package com.example.user3.guideapp;

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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user3.guideapp.Api.Api;
import com.example.user3.guideapp.Model.Week;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends  AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
   ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.navigation_drawer);

        toolbar =findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

         drawerLayout=findViewById(R.id.drawer_layout);
         navigationView=findViewById(R.id.navigation_view);
         navigationView.setNavigationItemSelectedListener(this);

         ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();

        listView=findViewById(R.id.listViewHeroes);

        getheros();
       //setSupportActionBar(toolbar);
      // getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
   public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu ,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this,"profile clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_logout:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this,"logout clicked",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_credits:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(this,"credits clicked",Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.home_id:
                Toast.makeText(this,"Home Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_profile_id:
                Toast.makeText(this,"Profile Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_course_id:
                Toast.makeText(this,"Course Clicked",Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer((GravityCompat.START));
        }else {super.onBackPressed();}


    }

    private void getheros()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<List<Week>> call = api.getWeeks();
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
        });
    }


}
