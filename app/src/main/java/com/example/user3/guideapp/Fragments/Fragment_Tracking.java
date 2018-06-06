package com.example.user3.guideapp.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.user3.guideapp.Adapters.CourseAdapter;
import com.example.user3.guideapp.R;

public class Fragment_Tracking extends DialogFragment {
    //http://guidedev.azurewebsites.net/api/LearnerApi/CourseTracking/COURSE1201800116/x
    ProgressBar progressBar;
    TextView textView;
    View view;
    String courseid,learnerid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_testimonial, container, false);
      // get the reference of Button

        progressBar = (ProgressBar)view.findViewById (R.id.circularProgressBar);
       // CourseAdapter ca=new CourseAdapter();
        //courseid=ca.getCourseid();
        progressBar.setProgress( 50 );

        // as 60 is max, we specified in the xml layout, 30 will be its half 😉
        textView=   (TextView)view. findViewById(R.id.textView1);

        textView.setText("50%");

        return view;
    }
}
