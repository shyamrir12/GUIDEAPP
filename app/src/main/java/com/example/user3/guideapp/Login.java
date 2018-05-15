package com.example.user3.guideapp;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
 Button register,login;
    CoordinatorLayout login_layout;
    AppCompatEditText emailedit,passwordedit;
    TextInputLayout emaillayout,passwordlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

register=findViewById(R.id.btn_register);
login=findViewById(R.id.btn_login);
login_layout =findViewById(R.id.login_layout_id);
emaillayout=findViewById(R.id.input_layout_email);
passwordlayout=findViewById(R.id.input_layout_password);
emailedit=findViewById(R.id.input_email);
passwordedit=findViewById(R.id.input_password);

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


                                         }
                                         else if( isEmailValid(emailedit.getText().toString())==false){

                                             emaillayout.setErrorEnabled(true);
                                             emaillayout.setError("Please Enter Valid Email..");

                                         }
                                         else

                                         {   emaillayout.setErrorEnabled(false);
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
        }
        else
        {   emaillayout.setErrorEnabled(false);}

    }
});

login_layout.setOnClickListener(null);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent log=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(log);
    }
});
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent reg=new Intent(getApplicationContext(),Register.class);
        startActivity(reg);
    }
});
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
}
