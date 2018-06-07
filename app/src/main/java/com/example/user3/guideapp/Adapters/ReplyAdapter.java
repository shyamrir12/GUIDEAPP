package com.example.user3.guideapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.R;

import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ReplyViewHolder>{
    private Context mCtx;

    //we are storing all the products in a list
    private List<CourseData.Datareply> ReplyList;

    public ReplyAdapter(Context mCtx, List<CourseData.Datareply> ReplyList) {
        this.mCtx = mCtx;
        this.ReplyList = ReplyList;

    }

    @Override
    public ReplyAdapter.ReplyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_reply, null);
        return new ReplyAdapter.ReplyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ReplyAdapter.ReplyViewHolder holder, int position) {

        //getting the product of the specified position
        CourseData.Datareply Reply =ReplyList.get(position);

        //binding the data with the viewholder views
        holder.textViewLearnerName.setText(Reply.getName());
        holder.textViewTime.setText(Reply.getRepliedOn());
        holder.textViewReply.setText(Reply.getReply());



    }

    @Override
    public int getItemCount() {
        return ReplyList.size();
    }
    class ReplyViewHolder extends RecyclerView.ViewHolder  {
        TextView textViewLearnerName, textViewTime,textViewReply;

        public ReplyViewHolder(View itemView ) {
            super(itemView);


            textViewLearnerName = itemView.findViewById(R.id.textViewLearnerName);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewReply = itemView.findViewById(R.id.textViewReply);


        }


    }
}
