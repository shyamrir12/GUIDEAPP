package com.example.user3.guideapp.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user3.guideapp.Adapters.WeekAdapter;
import com.example.user3.guideapp.ContentDetails;
import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.R;

import java.util.HashMap;
import java.util.List;

public class Fragment_Lecture extends android.support.v4.app.Fragment {

    View view;
    String courseid;
    WeekAdapter weekAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CourseDetails cd = (CourseDetails) getActivity();
        listDataHeader= cd.getHeaderList();
        listDataChild=cd.getChildList();
        courseid=cd.getCourseid();
        view = inflater.inflate(R.layout.fragment_lecture, container, false);

        expListView= (ExpandableListView)view.findViewById(R.id.expandableListViewlecture);


        weekAdapter = new WeekAdapter(getActivity(), listDataHeader, listDataChild);

        expListView.setAdapter(weekAdapter);
        // for(int g=0; g < weekAdapter.getGroupCount(); g++)
        //     expListView.expandGroup(g);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {



                String contentid=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                contentid=contentid.substring(contentid.lastIndexOf(",") + 1);

                Intent contentdetails = new Intent(getActivity(),ContentDetails.class);
                contentdetails.putExtra("contentid",contentid);
                contentdetails.putExtra("courseid",courseid);
                // Toast.makeText(CourseDetails.this,contentid,Toast.LENGTH_SHORT).show();
                startActivity(contentdetails);
                return false;
            }
        });
        return view;
    }


}