package com.example.user3.guideapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user3.guideapp.Fragments.Fragment_Comment;
import com.example.user3.guideapp.Fragments.Fragment_Reply;

public class Reply extends AppCompatActivity {
String courseid, learnerName,time, comment;
int commentid,commentno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        courseid=getIntent().getStringExtra("courseid");
        commentid=getIntent().getIntExtra("commantid",0);
        commentno=getIntent().getIntExtra("commentno",0);
       learnerName=getIntent().getStringExtra("LearnerName");
        time=getIntent().getStringExtra("Time");
        comment=getIntent().getStringExtra("Comment");
        loadreply();
    }

    public String getCourseid() {
        return courseid;
    }
    public int getCommentid() {
        return commentid;
    }
    public int getCommentNo() {
        return commentno;
    }
    public String getLearnerName() {
        return learnerName;
    }

    public String getTime() {
        return time;
    }

    public String getComment() {
        return comment;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void loadreply() {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();

// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
      Fragment_Reply fragment=new Fragment_Reply();
        fragmentTransaction.replace( R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
