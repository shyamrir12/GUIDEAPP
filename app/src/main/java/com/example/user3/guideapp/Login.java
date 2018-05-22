package com.example.user3.guideapp;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user3.guideapp.Api.Api;
import com.example.user3.guideapp.Api.GuideApi;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.Token;
import com.example.user3.guideapp.Model.TokenRequest;
import com.example.user3.guideapp.Model.TokenResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Login extends AppCompatActivity {
    Button register, login;
    CoordinatorLayout login_layout;
    AppCompatEditText emailedit, passwordedit;
    TextInputLayout emaillayout, passwordlayout;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        register = findViewById(R.id.btn_register);
        login = findViewById(R.id.btn_login);
        login_layout = findViewById(R.id.login_layout_id);
        emaillayout = findViewById(R.id.input_layout_email);
        passwordlayout = findViewById(R.id.input_layout_password);
        emailedit = findViewById(R.id.input_email);
        passwordedit = findViewById(R.id.input_password);
        progressBar.setVisibility(View.INVISIBLE);
        passwordlayout.setCounterEnabled(true);
        passwordlayout.setCounterMaxLength(10);
        emaillayout.setCounterEnabled(true);
        emaillayout.setCounterMaxLength(100);

        emailedit.addTextChangedListener(new TextWatcher() {
                                             @Override
                                             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                             }

                                             @Override
                                             public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                 if (emailedit.getText().toString().isEmpty()) {
                                                     emaillayout.setErrorEnabled(true);
                                                     emaillayout.setError("Please Enter Your Email..");


                                                 } else if (isEmailValid(emailedit.getText().toString()) == false) {

                                                     emaillayout.setErrorEnabled(true);
                                                     emaillayout.setError("Please Enter Valid Email..");

                                                 } else

                                                 {
                                                     emaillayout.setErrorEnabled(false);
                                                 }
                                             }

                                             @Override
                                             public void afterTextChanged(Editable s) {

                                             }
                                         }

        );


        emailedit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (emailedit.getText().toString().isEmpty()) {
                    emaillayout.setErrorEnabled(true);
                    emaillayout.setError("Please Enter Your Email..");
                } else {
                    emaillayout.setErrorEnabled(false);
                }

            }
        });

        login_layout.setOnClickListener(null);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent log=new Intent(getApplicationContext(),MainActivity.class);
                //  startActivity(log);
                if (emailedit.getText().toString().isEmpty()) {
                    emaillayout.setErrorEnabled(true);
                    emaillayout.setError("Please Enter Your Email..");


                } else if (isEmailValid(emailedit.getText().toString()) == false) {

                    emaillayout.setErrorEnabled(true);
                    emaillayout.setError("Please Enter Valid Email..");

                } else

                {
                    emaillayout.setErrorEnabled(false);
                    userLogin();
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(getApplicationContext(), Register.class);
                startActivity(reg);
            }
        });
        if(SharedPrefManager.getInstance(this).getUser().userName!=null)
        {
            Intent log = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(log);
        }
    }

    public static boolean isEmailValid(String emailtext) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailtext;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public void userLogin() {
       /* final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();*/

        progressBar.setVisibility(View.VISIBLE);
        try {
            //String res="";

            new POSTLogin().execute(emailedit.getText().toString(), passwordedit.getText().toString());

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            // progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
   /*     Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GuideApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        GuideApi guideApi = retrofit.create(GuideApi.class);



        TokenRequest tokenRequest=new TokenRequest();
        tokenRequest.setUsername(emailedit.getText().toString());
        tokenRequest.setPassword(passwordedit.getText().toString());
        tokenRequest.setGrant_type("password");

     Call<TokenResponse> tokenResponseCall= guideApi.gettoken(tokenRequest);
     tokenResponseCall.enqueue(new Callback<TokenResponse>() {
    @Override
     public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
        int statusCode=response.code();
        TokenResponse tokenResponse=response.body();
        progressDialog.dismiss();
        Log.d("login","onResponse :"+statusCode);
        Intent log=new Intent(getApplicationContext(),MainActivity.class);
         startActivity(log);

    }

    @Override
     public void onFailure(Call<TokenResponse> call, Throwable t) {
        Log.d("login","onResponse :"+t.getMessage());
        progressDialog.dismiss();
    }
});*/

    }

    private class POSTLogin extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream = null;
            String cliente = params[0];
            String clave = params[1];
            //String res = params[2];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url("http://guidedev.azurewebsites.net/token");
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");

                FormBody.Builder parameters = new FormBody.Builder();
                parameters.add("grant_type", "password");
                parameters.add("username", cliente);
                parameters.add("password", clave);
                builder.post(parameters.build());

                Response response = client.newCall(builder.build()).execute();

                if (response.isSuccessful()) {
                    json = response.body().string();
                    //System.out.println(json);
                    Gson gson = new Gson();
                    Token jsonbody = gson.fromJson(json, Token.class);
                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(jsonbody);

                    //System.out.println(jsonbody.userName+":"+ jsonbody.access_token);
                    //res=json;
                    //System.out.println("CONTENIDO::  " + json);
                    //Toast.makeText(getApplicationContext(),json,Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                //System.out.println("Error: " + e);
                // Toast.makeText(getApplicationContext(),"Error: " + e,Toast.LENGTH_SHORT).show();
            }


            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Invalid user id or password", Toast.LENGTH_SHORT).show();
            } else {
                progressBar.setVisibility(View.INVISIBLE);

                Intent log = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(log);
            }
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            //progressDialog.dismiss();

        }
    }
}
