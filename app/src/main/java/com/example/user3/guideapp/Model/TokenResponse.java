package com.example.user3.guideapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenResponse {
    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getUserName() {
        return userName;
    }

    @SerializedName("access_token")
    @Expose
    private String access_token ;
    @SerializedName("token_type")
    @Expose
    private String token_type ;
    @SerializedName("expires_in")
    @Expose
    private int expires_in ;
    @SerializedName("userName")
    @Expose
    private String userName ;
   // private String issued ;
   // private String expires ;
}
