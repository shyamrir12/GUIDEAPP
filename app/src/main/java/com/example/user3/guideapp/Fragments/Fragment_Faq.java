package com.example.user3.guideapp.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user3.guideapp.Adapters.CommentAdapter;
import com.example.user3.guideapp.Adapters.FaqAdapter;
import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.Course_Details_Tab;
import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.R;

import java.util.List;

public class Fragment_Faq  extends android.support.v4.app.Fragment {
    View view;
    List<CourseData.DataCourseFaq> faqList;
    FaqAdapter adapterFaq;
    RecyclerView recyclerViewFaq;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Course_Details_Tab cd = (Course_Details_Tab) getActivity();
        faqList= cd.getfaqList();

        view = inflater.inflate(R.layout.fragment_faq, container, false);
        recyclerViewFaq = (RecyclerView) view.findViewById(R.id.recyclerViewFaq);
        adapterFaq=new FaqAdapter(getActivity(),faqList);
        recyclerViewFaq.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewFaq.setAdapter(adapterFaq);
        return view;
        }

    }



