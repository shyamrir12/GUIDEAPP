package com.example.user3.guideapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.RegisterData;
import com.example.user3.guideapp.Model.Result;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Register extends AppCompatActivity {

MaterialSpinner spinner;
     Button buttonRegister;
    ProgressDialog progressDialog;
    EditText input_name,input_email,input_mobile,input_confirmpassword,input_password;
    String courseid;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] ITEMS = {"Learner"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (MaterialSpinner) findViewById(R.id.materialSpinner);
        buttonRegister=findViewById(R.id.btn_signup);
        input_name=findViewById(R.id.input_name);
        input_email=findViewById(R.id.input_email);
        input_mobile=findViewById(R.id.input_mobile);
        input_confirmpassword=findViewById(R.id.input_confirmpassword);
        input_password=findViewById(R.id.input_password);
        courseid=getIntent().getStringExtra("courseid");
        progressDialog = new ProgressDialog(this);
        spinner.setAdapter(adapter);
        spinner.setSelection(1,true);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRegister();
            }
        });


    }
    public void saveRegister() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();

          String name=input_name.getText().toString();
            String email=input_email.getText().toString();
            String mobile=input_mobile.getText().toString();
            String conpassword=input_confirmpassword.getText().toString();
            String role=spinner.getSelectedItem().toString();
            String password=input_password.getText().toString();
            new Register.POSTRegister().execute(name,email,mobile,password,role,courseid,conpassword);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    private class POSTRegister extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream

            String name = params[0];
            String email = params[1];
            String  mobile= params[2];
            String password = params[3];
            String role = params[4];
            String courseid = params[5];
            String conpassword=params[6];
            if(courseid==null)
                courseid="";
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url(PlayerConfig.BASE_URL_API+"Account/Register");
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                FormBody.Builder parameters = new FormBody.Builder();
               parameters.add("UserName", name);
                parameters.add("Email", email);
                parameters.add("PhoneNumber", mobile);
               parameters.add("Password",password );
                parameters.add("Role",role );
                parameters.add("CourseID",courseid );
                parameters.add("ConfirmPassword",conpassword );
                builder.post(parameters.build());
                okhttp3.Response response = client.newCall(builder.build()).execute();
                if (response.isSuccessful()) {
                    json = response.body().string();

                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(Register.this, "Error: " + e, Toast.LENGTH_SHORT).show();
            }
            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(Register.this, "Invalid request", Toast.LENGTH_SHORT).show();
            }
            /* else {
                if(responcecode==200) {
                    Toast.makeText(Register.this,"Registration successful", Toast.LENGTH_SHORT).show();
                }*/
                else {
                    //System.out.println("CONTENIDO:  " + result);
                    Gson gson = new Gson();
               RegisterData.RootObject jsonbodys = gson.fromJson(result, RegisterData.RootObject.class);

               if(jsonbodys.dataIdentityResult.getSucceeded()==true)
               {
                   Toast.makeText(Register.this, jsonbodys.getMessage(), Toast.LENGTH_SHORT).show();
                   builder = new AlertDialog.Builder(Register.this);
                   builder.setCancelable(true);
                   builder.setTitle("Congratulations");

                   builder.setMessage("Go for login.");
                   builder.setPositiveButton("Login",
                           new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                 //login
                                   Intent intent=new Intent(Register.this,Login.class);
                                    Register.this.startActivity(intent);
                               }
                           });
                         builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           // finish();
                       }
                   });
                   AlertDialog dialog = builder.create();
                   dialog.show();
               }
               else {


                   Toast.makeText(Register.this,jsonbodys.dataIdentityResult.getErrors().get(0) , Toast.LENGTH_SHORT).show();
               }
            }
           progressDialog.dismiss();
            }
        }

    }

