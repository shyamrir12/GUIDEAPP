package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.Api.Api;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.Result;
import com.example.user3.guideapp.Model.Week;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeekMaster extends AppCompatActivity {
TextView weekid,weekname;
Button saveweek,updateweek,deleteweekss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_master);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        weekid=findViewById(R.id.input_WeekID);
        weekname=findViewById(R.id.input_WeekName);
        saveweek=findViewById(R.id.btn_saveweek);
        updateweek=findViewById(R.id.btn_updateweek);
        deleteweekss=findViewById(R.id.btn_deleteweeks);

        deleteweekss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteweeksss();
            }
        });


            updateweek.setOnClickListener(new View.OnClickListener() {
              @Override
               public void onClick(View v) {
             updateweeks();
              }
          });
        saveweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveweek();
            }
        });
        getWeeksss();
    }
    protected void getWeeksss(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();



        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        Api service = retrofit.create(Api.class);

        //Defining the user object as we need to pass it with the call

        Call<Week> call = service.getWeeks(2,": Bearer "+SharedPrefManager.getInstance(this).getUser().access_token);

       call.enqueue(new Callback<Week>() {
           @Override
           public void onResponse(Call<Week> call, Response<Week> response) {
               progressDialog.dismiss();
               Week week=response.body();
               Log.d("WeekName",week.getWeekName());
              String wid=String.valueOf(week.getWeekID());
               weekid.setText(wid);
               weekname.setText(week.getWeekName());
           }

           @Override
           public void onFailure(Call<Week> call, Throwable t) {
               progressDialog.dismiss();
               Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
           }
       });
    }
    protected void   deleteweeksss(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        int varweekid =Integer.parseInt( weekid.getText().toString().trim());

        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        Api service = retrofit.create(Api.class);

        //Defining the user object as we need to pass it with the call

        Call<Result> call = service.deleteWeeks(varweekid);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();

                int statusCode=response.code();
                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(),response.message()+String.valueOf(statusCode), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    protected  void  updateweeks(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        int varweekid =Integer.parseInt( weekid.getText().toString().trim());
        String varweekname = weekname.getText().toString().trim();
        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        Api service = retrofit.create(Api.class);

        //Defining the user object as we need to pass it with the call
        Week week = new Week(varweekid,varweekname);
        Call<Result> call = service.updateWeek(week);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();

                int statusCode=response.code();
                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(),response.message()+String.valueOf(statusCode), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    protected void saveweek()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        int varweekid =Integer.parseInt( weekid.getText().toString().trim());
        String varweekname = weekname.getText().toString().trim();
         //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        Api service = retrofit.create(Api.class);

        //Defining the user object as we need to pass it with the call
        Week week = new Week(varweekid,varweekname);
        Call<Result> call = service.createWeek(week);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();

                int statusCode=response.code();
                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(),response.message()+String.valueOf(statusCode), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
