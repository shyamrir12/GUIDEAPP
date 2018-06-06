package com.example.user3.guideapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user3.guideapp.Fragments.Fragment_Comment;
import com.example.user3.guideapp.Fragments.Fragment_Reply;

public class Reply extends AppCompatActivity {
String courseid,commentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        courseid=getIntent().getStringExtra("courseid");
        commentid=getIntent().getStringExtra("commantid");
        loadreply();
    }

    public String getCourseid() {
        return courseid;
    }
    public String getCommentid() {
        return commentid;
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
