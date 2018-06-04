package com.example.user3.guideapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.R;

import java.util.List;

public class TestimonialAdapters  extends RecyclerView.Adapter<TestimonialAdapters.TestimonialViewHolder> {
    private Context mCtx;
    //we are storing all the products in a list
    private List<CourseData.DatacourseTestimonial > testimonialList;

    public  TestimonialAdapters(Context mCtx, List<CourseData.DatacourseTestimonial> testimonialList)
    {
        this.mCtx=mCtx;
        this.testimonialList= testimonialList;
    }
    @Override

    public TestimonialViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_testimonial, null);
        return new TestimonialViewHolder(view,mCtx,testimonialList);

    }

    @Override
    public void onBindViewHolder(TestimonialViewHolder holder, int position) {

        CourseData.DatacourseTestimonial  testimonial =testimonialList.get(position);

        //binding the data with the viewholder views
        holder.textViewLearnerName.setText(testimonial.getLearnerName());
        holder.textViewTestimonial.setText(testimonial.getTestimonial());
        holder.ratingBar.setRating(testimonial.getRating());
        //holder.textViewrate.setText(String.valueOf(testimonial.getRating()));

    }

    @Override
    public int getItemCount() {
        return testimonialList.size();
    }
    class TestimonialViewHolder extends RecyclerView.ViewHolder  {

        TextView textViewLearnerName, textViewTestimonial,textViewrate;
         RatingBar ratingBar;


        public TestimonialViewHolder(View itemView, Context mCtx, List<CourseData.DatacourseTestimonial> testimonialList ) {
            super(itemView);

            textViewLearnerName = itemView.findViewById(R.id.textViewLearnerName);
            textViewTestimonial = itemView.findViewById(R.id.textViewTestimonial);
           // textViewrate=itemView.findViewById(R.id.textViewrate);
            ratingBar = itemView.findViewById(R.id.ratingBar);

        }

    }
}
