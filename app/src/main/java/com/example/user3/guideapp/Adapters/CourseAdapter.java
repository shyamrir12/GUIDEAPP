package com.example.user3.guideapp.Adapters;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.R;

import java.net.URL;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<HomeData.DataCourse> courseList;
    private List<HomeData.DataCourseBanner> bannrList;
    private List<HomeData.DataRating> ratingList;

    //getting the context and product list with constructor
    public CourseAdapter(Context mCtx, List<HomeData.DataCourse> courseList, List<HomeData.DataCourseBanner> bannerList, List<HomeData.DataRating> ratingList) {
        this.mCtx = mCtx;
        this.courseList = courseList;
        this.bannrList=bannerList;
        this.ratingList=ratingList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_courses, null);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {

        //getting the product of the specified position
        HomeData.DataCourse course = courseList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(course.getCourseName());
        holder.textViewShortDesc.setText(course.getCourseDescription());
        holder.textViewRating.setText(String.valueOf(course.getDuration()));
        holder.textViewPrice.setText(String.valueOf(course.getCoursePrice()));


        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable();

    }


    @Override
    public int getItemCount() {
        return courseList.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public CourseViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewInstructorName);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}