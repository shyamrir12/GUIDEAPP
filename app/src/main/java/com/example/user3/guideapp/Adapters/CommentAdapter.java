package com.example.user3.guideapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user3.guideapp.CourseDetails;
import com.example.user3.guideapp.Model.CourseData;
import com.example.user3.guideapp.R;
import com.example.user3.guideapp.Reply;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;
    //we are storing all the products in a list
    private List<CourseData.Dataforum> commentList;
    //getting the context and product list with constructor
    public CommentAdapter(Context mCtx, List<CourseData.Dataforum> commentList ) {
        this.mCtx = mCtx;
        this.commentList = commentList;

    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_comment, null);
        return new CommentViewHolder(view,mCtx,commentList);

    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        //getting the product of the specified position
      CourseData.Dataforum comment =commentList.get(position);
      int commentno=position+1;
         //binding the data with the viewholder views
        holder.textViewCommentNumber.setText("Comment :"+commentno);
        holder.textViewLearnerName.setText(comment.getName());
        holder.textViewTime.setText(comment.getCommentedOn());
        holder.textViewComment.setText(comment.getComment());
        holder.textViewReply.setText("Reply:"+comment.getTotalReply());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        TextView textViewCommentNumber, textViewLearnerName,textViewTime,textViewComment,textViewReply;
        Button buttonreply;
        private Context mCtx;
        //we are storing all the products in a list
        private List<CourseData.Dataforum> commentList;
        public CommentViewHolder(View itemView,Context mCtx,List<CourseData.Dataforum> commentList ) {
            super(itemView);
            this.mCtx=mCtx;
            this.commentList=commentList;
            itemView.setOnClickListener(this);
            textViewCommentNumber = itemView.findViewById(R.id.textViewCommentNumber);
            textViewLearnerName = itemView.findViewById(R.id.textViewLearnerName);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewComment = itemView.findViewById(R.id.textViewComment);
            textViewReply = itemView.findViewById(R.id.textViewReply);
            buttonreply = itemView.findViewById(R.id.buttonreply);
            buttonreply.setOnClickListener(this);
        }


        @Override
        public boolean onLongClick(View v) {
            return false;
        }


        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            CourseData.Dataforum comment =this.commentList.get(position);
            if (v.getId() == buttonreply.getId()) {
                Intent intent=new Intent(mCtx, Reply.class);
                intent.putExtra("courseid",comment.getCourseID());
                intent.putExtra("commantid",comment.getCommentId());

                intent.putExtra("commentno",position);
                intent.putExtra("LearnerName",comment.getName());
                intent.putExtra("Time",comment.getCommentedOn());
                intent.putExtra("Comment",comment.getComment());
                //intent.putExtra("ReplyNumber",comment.getCommentId());

                this.mCtx.startActivity(intent);
            }
        }
    }
}
