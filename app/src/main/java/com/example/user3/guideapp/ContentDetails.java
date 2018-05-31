package com.example.user3.guideapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.user3.guideapp.Adapters.WeekAdapter;
import com.example.user3.guideapp.Config.PlayerConfig;
import com.example.user3.guideapp.Helper.SharedPrefManager;
import com.example.user3.guideapp.Model.ContentDetailsData;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ContentDetails extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String courseid,contentid;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    WeekAdapter weekAdapter;
    ExpandableListView expListView;
    ProgressDialog progressDialog;

    private YouTubePlayerView videoPlayer;

    private static final String API_KEY = "AIzaSyCPtfrnpWo3eHbmMchX2lySsIUclDHTr_s";
    String VIDEO_ID;

    ContentDetailsData.DataCourseContent dcc;
    List<ContentDetailsData.DataCourseContentrecord> dccr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_details);
        expListView=findViewById(R.id.expandableListViewlecture);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        courseid=getIntent().getStringExtra("courseid");
        contentid=getIntent().getStringExtra("contentid");
        progressDialog = new ProgressDialog(this);

        videoPlayer = (YouTubePlayerView)findViewById(R.id.youTubePlayerView);


        getMyContentDesc();


        //listDataHeader =  (ArrayList<String>)getIntent().getSerializableExtra("BUNDLE1");
        //listDataChild =  (HashMap<String, List<String>>)getIntent().getSerializableExtra("BUNDLE2");



    }
    /*@Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }*/
    public  void getembedContent(String contentid)
    {
        for(int l = 0; l < dccr.size(); l++)
        {
           // Toast.makeText(this,dccr.get(l).getContentType()+String.valueOf(dccr.get(l).getContentID())+contentid,Toast.LENGTH_SHORT).show();
            if(dccr.get(l).getContentID()==Integer.parseInt(contentid)) {
                VIDEO_ID= getYoutubeID(dccr.get(l).getContentURL());
               Toast.makeText(this,VIDEO_ID,Toast.LENGTH_SHORT).show();


               // videoPlayer.initialize(API_KEY, this);
            }
        }
    }

    public static String getYoutubeID(String youtubeUrl) {

        if (TextUtils.isEmpty(youtubeUrl)) {
            return "";
        }
        String video_id = "";

        String expression = "^.*((youtu.be" + "\\/)" + "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*"; // var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
        CharSequence input = youtubeUrl;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String groupIndex1 = matcher.group(7);
            if (groupIndex1 != null && groupIndex1.length() == 11)
                video_id = groupIndex1;
        }
        if (TextUtils.isEmpty(video_id)) {
            if (youtubeUrl.contains("youtu.be/")  ) {
                String spl = youtubeUrl.split("youtu.be/")[1];
                if (spl.contains("\\?")) {
                    video_id = spl.split("\\?")[0];
                }else {
                    video_id =spl;
                }

            }
        }

        return video_id;
    }
    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
    public void getMyContentDesc() {
        try {
            //String res="";
            progressDialog.setMessage("loading...");
            progressDialog.show();
            new ContentDetails.GETContentDetails().execute(SharedPrefManager.getInstance(this).getUser().access_token,courseid,contentid);

            //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            // System.out.println("Error: " + e);
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean complete) {
        if (!complete) {
            youTubePlayer.cueVideo(VIDEO_ID);
            youTubePlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        //Toast.makeText(ContentDetails.this, youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
    }

    private class GETContentDetails extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            //     InputStream inputStream
            String accesstoken = params[0];
            String courseid = params[1];
            String contentid = params[2];
            //String res = params[2];
            String json = "";
            try {

                OkHttpClient client = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                builder.url("http://guidedev.azurewebsites.net/api/InstructorApi/GetContentDetails/"+contentid+"/"+courseid);
                builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", "Bearer " + accesstoken);

               /* FormBody.Builder parameters = new FormBody.Builder();
                parameters.add("grant_type", "password");
                parameters.add("username", cliente);
                parameters.add("password", clave);
                builder.post(parameters.build());
                */
                okhttp3.Response response = client.newCall(builder.build()).execute();

                if (response.isSuccessful()) {
                    json = response.body().string();


                }
            } catch (Exception e) {
                e.printStackTrace();
                progressDialog.dismiss();
                // System.out.println("Error: " + e);
                Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
            }
            return json;
        }

        protected void onPostExecute(String result) {

            if (result.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Invalid request", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println("CONTENIDO:  " + result);
                Gson gson = new Gson();
              final ContentDetailsData.RootObject jsonbodys = gson.fromJson(result, ContentDetailsData.RootObject.class);

                List<ContentDetailsData.DataCourseContentrecord> cc=jsonbodys.dataCourseContentrecord;
               List<ContentDetailsData.DataWeek > dw=jsonbodys.dataWeek;
                List<ContentDetailsData.DataTopic > dt=jsonbodys.dataTopic;
                dcc=jsonbodys.dataCourseContent;
                VIDEO_ID= getYoutubeID(dcc.getContentURL());
                dccr=jsonbodys.dataCourseContentrecord;
                videoPlayer.initialize(API_KEY, ContentDetails.this);


                listDataHeader = new ArrayList<String>();
                listDataChild = new HashMap<String, List<String>>();

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < dw.size(); i++) {

                    listDataHeader.add(dw.get(i).getWeekName());

                    List<String>  wn  = new ArrayList<String>();
                    for(int j = 0; j < dt.size(); j++)
                    {
                        if(dt.get(j).getWeekID()==dw.get(i).getWeekID()) {
                            for(int k=0;k<cc.size();k++){
                                if(dt.get(j).getTopicID()==cc.get(k).getTopicID()){
                                    String contentid=Integer.toString( cc.get(k).getContentID());
                                    String lecture=dt.get(j).getTopicName()+":"+cc.get(k).getContentTitle()+","+contentid;

                                    wn.add(lecture);

                                }
                            }
                        }
                    }
                    listDataChild.put( dw.get(i).getWeekName(), wn);
                    //System.out.println("Weekname:"+ weeks[i]);
                }
                weekAdapter = new WeekAdapter(ContentDetails.this, listDataHeader, listDataChild);

                expListView.setAdapter(weekAdapter);
                expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                        String contentid=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                        contentid=contentid.substring(contentid.lastIndexOf(",") + 1);
                        getembedContent(contentid);


                        return false;
                    }
                });
                expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        setListViewHeight(parent, groupPosition);
                        return false;
                    }
                });

                progressDialog.dismiss();

            }


        }

    }
   /* @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("courseid", courseid);
        setResult(RESULT_OK, intent);
        finish();
    }*/
}
