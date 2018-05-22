package com.example.user3.guideapp.Api;
import com.example.user3.guideapp.Model.Result;
import com.example.user3.guideapp.Model.Week;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "http://guidedev.azurewebsites.net/api/AdminApi/";

    @GET("GetWeekMaster")
    Call<List<Week>> getWeeks(@Header("Authorization") String authHeader);

    @GET("GetWeekMaster/{WeekId}")
    Call<Week> getWeeks(@Path("WeekId") int WeekId,@Header("Authorization") String authHeader);

    @POST("PostWeekMaster")
    Call<Result> createWeek( @Body Week week);

    @PUT("PutWeekMaster/{WeekId}")
    Call<Result> updateWeek(
            @Body Week week
    );

    @DELETE("DeleteWeekMaster/{WeekId}")
    Call<Result> deleteWeeks(@Path("WeekId") int WeekId);


}
