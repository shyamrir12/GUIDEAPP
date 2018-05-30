package com.example.user3.guideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContentDetails extends AppCompatActivity {
    TextView textCourseIdcontentid;
    String courseid,contentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        courseid=getIntent().getStringExtra("courseid");
        contentid=getIntent().getStringExtra("contentid");


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
   /* @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("courseid", courseid);
        setResult(RESULT_OK, intent);
        finish();
    }*/
}
