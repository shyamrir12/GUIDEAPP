package com.example.user3.guideapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.Model.HomeData;
import com.example.user3.guideapp.R;

import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder>{
    private Context mCtx;

    //we are storing all the products in a list
    private List<CourseData.DataCourseFaq> faqList;

    public FaqAdapter(Context mCtx, List<CourseData.DataCourseFaq> faqList) {
        this.mCtx = mCtx;
        this.faqList = faqList;

    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_faq, null);
        return new FaqViewHolder(view);

    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {

        //getting the product of the specified position
       CourseData.DataCourseFaq faq =faqList.get(position);

        //binding the data with the viewholder views
        holder.textViewQuestion.setText(faq.getQuestion());
        holder.textViewAnswer.setText(faq.getAnswer());




    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }
    class FaqViewHolder extends RecyclerView.ViewHolder  {
        TextView textViewQuestion, textViewAnswer;

        public FaqViewHolder(View itemView ) {
            super(itemView);


            textViewQuestion = itemView.findViewById(R.id.textViewQuestion);
            textViewAnswer = itemView.findViewById(R.id.textViewAnswer);


        }


    }
}
