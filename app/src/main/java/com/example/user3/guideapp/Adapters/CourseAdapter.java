package com.example.user3.guideapp.Adapters;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.Course_Details_Tab;
import com.example.user3.guideapp.Course_Tracking;
import com.example.user3.guideapp.Fragments.Fragment_Testimonial;
import com.example.user3.guideapp.Fragments.Fragment_Tracking;
import com.example.user3.guideapp.MainActivity;
import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.MyCourse;
import com.example.user3.guideapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<HomeData.DataCourse> courseList;


    //getting the context and product list with constructor
    public CourseAdapter(Context mCtx, List<HomeData.DataCourse> courseList) {
        this.mCtx = mCtx;
        this.courseList = courseList;

    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)   {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_courses, null);
        return new CourseViewHolder(view,mCtx,courseList);

    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {

        String imgurl="";
       //getting the product of the specified position
        HomeData.DataCourse course = courseList.get(position);
          if(course.FileId!=0)
         imgurl="https://guidedevblob.blob.core.windows.net/"+course.getCourseID().toLowerCase()+"/"+course.getFileId()+"/"+course.getFileName().replace(' ','_').toLowerCase();
         else
         imgurl="https://www.homesbykimblanton.com/uploads/shared/images/library%202.jpg";
        //binding the data with the viewholder views
        holder.textViewTitle.setText(course.getCourseName());
        holder.textViewShortDesc.setText(course.getCourseDescription());
        holder.ratingBar.setRating(course.getAvrageRating());
        holder.textViewPrice.setText(String.valueOf(course.getCoursePrice()+" "+course.getCurrency()));
        Picasso.with(this.mCtx).load(imgurl).into(holder.imageView);

        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable();


    }


    @Override
    public int getItemCount() {
        return courseList.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener {

        TextView textViewTitle, textViewShortDesc, textViewPrice;
        Button button;
        RatingBar ratingBar;
        private Context mCtx;
        //we are storing all the products in a list
        private List<HomeData.DataCourse> courseList;

        ImageView imageView;

        public CourseViewHolder(View itemView,Context mCtx, List<HomeData.DataCourse> courseList ) {
            super(itemView);
            this.mCtx=mCtx;
            this.courseList=courseList;
            itemView.setOnClickListener(this);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewInstructorName);
            button=itemView.findViewById(R.id.button);
            textViewShortDesc.setMaxLines(2);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(this);
            textViewTitle.setOnClickListener(this);
            button.setOnClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            HomeData.DataCourse course =this.courseList.get(position);

            if (v.getId() == imageView.getId()||v.getId() == textViewTitle.getId()) {
                Intent intent=new Intent(mCtx, Course_Details_Tab.class);
                intent.putExtra("courseid",course.getCourseID());
                this.mCtx.startActivity(intent);
            }
            else if(v.getId()==button.getId())
            {
               Intent intent=new Intent(mCtx, Course_Tracking.class);
                intent.putExtra("courseid",course.getCourseID());
                this.mCtx.startActivity(intent);
            }
            }


        }

    }


