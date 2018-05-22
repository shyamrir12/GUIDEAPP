package com.example.user3.guideapp.Api;
import com.example.user3.guideapp.Model.Result;
import com.example.user3.guideapp.Model.TokenRequest;
import com.example.user3.guideapp.Model.TokenResponse;
import com.example.user3.guideapp.Model.Week;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface GuideApi {
    String BASE_URL = "http://guidedev.azurewebsites.net/";

    @POST("token")
    Call<TokenResponse> gettoken(@Body TokenRequest tokenRequest);
}
