package com.example.user3.guideapp.Adapters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.ItemClickListener;
import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.MyCourse;
import com.example.user3.guideapp.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<HomeData.CourseApiList> courseList;


    //getting the context and product list with constructor
    public CourseAdapter(Context mCtx, List<HomeData.CourseApiList> courseList) {
        this.mCtx = mCtx;
        this.courseList = courseList;

    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)   {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_courses, null);
        return new CourseViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {


       //getting the product of the specified position
        HomeData.CourseApiList course = courseList.get(position);
        String imgurl="https://guidedevblob.blob.core.windows.net/"+course.getCourseID().toLowerCase()+"/"+course.getFileId()+"/"+course.getFileName().replace(' ','_').toLowerCase();

        //binding the data with the viewholder views
        holder.textViewTitle.setText(course.getCourseName());
        holder.textViewShortDesc.setText(course.getCourseDescription());
        holder.textViewRating.setText(String.valueOf(course.getAvrageRating()));
        holder.textViewPrice.setText(String.valueOf(course.getCoursePrice()+" "+course.getCurrency()));

        Picasso.with(this.mCtx).load(imgurl).into(holder.imageView);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public View onClick(View view, int Position, boolean isLongClick) {
               if(isLongClick){
                   Intent log = new Intent(mCtx.getApplicationContext(),CourseDetails.class);
                   mCtx.startActivity(log);
               }
               return  view;
            }
        });
        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable();


    }


    @Override
    public int getItemCount() {
        return courseList.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        private ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }
        @Override
        public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
            return false;
        }

        ImageView imageView;

        public CourseViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewInstructorName);
            textViewShortDesc.setMaxLines(2);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}