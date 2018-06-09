package com.example.user3.guideapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user3.guideapp.Fragments.Fragment_Comment;
import com.example.user3.guideapp.Fragments.Fragment_Faq;
import com.example.user3.guideapp.Fragments.Fragment_Lecture;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    public void addFragment(Fragment fragments, String titles) {
        this.fragments.add(fragments);
        this.titles.add(titles);
    }

    public PagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);

    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
