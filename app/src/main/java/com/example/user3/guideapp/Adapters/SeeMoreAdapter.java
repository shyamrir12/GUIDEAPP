package com.example.user3.guideapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user3.guideapp.CartActivity;
import com.example.user3.guideapp.Course_Details_Tab;
import com.example.user3.guideapp.Course_Tracking;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.Model.RegisterData;
import com.example.user3.guideapp.Model.SeeMoreData;
import com.example.user3.guideapp.R;
import com.example.user3.guideapp.Register;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SeeMoreAdapter extends RecyclerView.Adapter<SeeMoreAdapter.SeeMoreViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<SeeMoreData.Datacourselist> courseList;


    //getting the context and product list with constructor
    public SeeMoreAdapter(Context mCtx, List<SeeMoreData.Datacourselist> courseList) {
        this.mCtx = mCtx;
        this.courseList = courseList;

    }

    @Override
    public SeeMoreAdapter.SeeMoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType)   {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_see_more_list_item, null);
        return new SeeMoreAdapter.SeeMoreViewHolder(view,mCtx,courseList);

    }

    @Override
    public void onBindViewHolder(SeeMoreAdapter.SeeMoreViewHolder holder, int position) {

        String imgurl="";
        //getting the product of the specified position
        SeeMoreData.Datacourselist course = courseList.get(position);
        if(course.FileId!=0)
            imgurl="https://guidedevblob.blob.core.windows.net/"+course.getCourseID().toLowerCase()+"/"+course.getFileId()+"/"+course.getFileName().replace(' ','_').toLowerCase();
        else
            imgurl="https://www.homesbykimblanton.com/uploads/shared/images/library%202.jpg";
        //binding the data with the viewholder views
        holder.textViewTitle.setText(course.getCourseDescription());
        holder.textviewCoursename.setText(course.getCourseName());
        holder.ratingBar.setRating(course.getAvrageRating());
        holder.textViewPrice.setText(String.valueOf(course.getCoursePrice()+" "+course.getCurrency()));
        holder.textViewInstructorName.setText(course.getInstructorName());
        if(course.isSubscriptionStatus()==true)
        holder.button.setText("Already Enrolled");
        else
            holder.button.setText("Enroll");
        Picasso.with(this.mCtx).load(imgurl).into(holder.imageView);

        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable();


    }


    @Override
    public int getItemCount() {
        return courseList.size();
    }


    class SeeMoreViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener {

        TextView textViewTitle, textviewCoursename, textViewPrice,textViewInstructorName;
        Button button;
        RatingBar ratingBar;
        private Context mCtx;
        //we are storing all the products in a list
        private List<SeeMoreData.Datacourselist> courseList;

        ImageView imageView;

        public SeeMoreViewHolder(View itemView,Context mCtx, List<SeeMoreData.Datacourselist> courseList ) {
            super(itemView);
            this.mCtx=mCtx;
            this.courseList=courseList;
            itemView.setOnClickListener(this);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewInstructorName = itemView.findViewById(R.id.textViewInstructorName);
            textviewCoursename = itemView.findViewById(R.id.textviewCoursename);
            button=itemView.findViewById(R.id.button);
            textviewCoursename.setMaxLines(2);
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
            SeeMoreData.Datacourselist course =this.courseList.get(position);

            if (v.getId() == imageView.getId()||v.getId() == textViewTitle.getId()) {
                Intent intent=new Intent(mCtx,Course_Details_Tab.class);
                intent.putExtra("courseid",course.getCourseID());
                this.mCtx.startActivity(intent);
            }
            else if(v.getId()==button.getId())
            { if(course.isSubscriptionStatus()==true){
                Toast.makeText(mCtx,"Already Enrolled",Toast.LENGTH_SHORT).show();
                }
                else
            {
                if(SharedPrefManager.getInstance(mCtx).getUser().access_token.equals(""))
                {
                    Intent intent=new Intent(mCtx, Register.class);
                    intent.putExtra("courseid",course.getCourseID());
                    this.mCtx.startActivity(intent);
                }
                else
                {
                    //go to cart
                    Intent intent=new Intent(mCtx,CartActivity.class);
                    intent.putExtra("courseid",course.getCourseID());
                    this.mCtx.startActivity(intent);

                }

            }
            }
        }


    }

}

