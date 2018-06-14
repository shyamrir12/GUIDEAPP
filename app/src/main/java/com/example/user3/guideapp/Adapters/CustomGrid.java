package com.example.user3.guideapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user3.guideapp.R;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final String[] catid;
    private final int[] Imageid;

    public CustomGrid(Context c,String[] web,int[] Imageid ,String [] catid) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
        this.catid=catid;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_course, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            TextView textViewcatid = (TextView) grid.findViewById(R.id.grid_catid);
            textView.setText(web[position]);
            textViewcatid.setText(catid[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}