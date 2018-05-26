package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.Model.HomeData;

import java.util.List;

public class CourseDetails extends AppCompatActivity {
    ProgressDialog progressDialog ;
    List<CourseData.CourseDataResult> courseresultList;
    TextView textCourseId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textCourseId=findViewById(R.id.textViewCourseId);
        textCourseId.setText("Course Id: "+getIntent().getStringExtra("courseid"));
    }
}
