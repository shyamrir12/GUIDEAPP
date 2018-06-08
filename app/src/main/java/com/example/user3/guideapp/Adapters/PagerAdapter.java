package com.example.user3.guideapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.example.user3.guideapp.Fragments.Fragment_Comment;
import com.example.user3.guideapp.Fragments.Fragment_Faq;
import com.example.user3.guideapp.Fragments.Fragment_Lecture;

public class PagerAdapter extends FragmentStatePagerAdapter {
int noOfTabs;
PagerAdapter (FragmentManager fm,int noOfTabs)
{
    super(fm);
    this.noOfTabs=noOfTabs;
}
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                Fragment_Comment fc=new Fragment_Comment();
                return fc;
            case 1:
                Fragment_Faq ff=new Fragment_Faq();
                return ff;
            case 2:
                Fragment_Lecture fl=new Fragment_Lecture();
                return fl;
           default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
