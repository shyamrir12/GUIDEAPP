package com.example.user3.guideapp.Model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Belal on 14/04/17.
 */

public class Result {
    @SerializedName("Status")
    private Boolean Status;

    @SerializedName("Message")
    private String Message;

    @SerializedName("week")
    private Week week;

    public Result(String Message) {

        this.Message = Message;

    }

    public Boolean getStatus() {
        return Status;
    }

    public String getMessage() {
        return Message;
    }

    public Week getWeek() {
        return week;
    }
}