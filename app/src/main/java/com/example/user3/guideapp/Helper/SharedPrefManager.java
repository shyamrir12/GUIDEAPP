package com.example.user3.guideapp.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.user3.guideapp.Model.Token;


public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedprefretrofit";

    private static final String KEY_USER_TOKEN = "accesstoken";
   private static final String KEY_USER_TOKENTYPE = "tokentype";
    private static final String KEY_USER_EMAIL = "username";
    private static final String KEY_USER_EXPIRES = "expiresin";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(Token user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_TOKEN, user.access_token);
        editor.putString(KEY_USER_TOKENTYPE, user.token_type);
        editor.putString(KEY_USER_EMAIL, user.userName);
        editor.putInt(KEY_USER_EXPIRES, user.expires_in);
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USER_TOKEN, null) != null)
            return true;
        return false;
    }
    public Token getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Token token=new Token();
        token.access_token=sharedPreferences.getString(KEY_USER_TOKEN, null);

        token.token_type   =  sharedPreferences.getString(KEY_USER_TOKENTYPE, null);
                token.userName   =  sharedPreferences.getString(KEY_USER_EMAIL, null);
                token.expires_in =  sharedPreferences.getInt(KEY_USER_EXPIRES, 0);

        return  token;
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}