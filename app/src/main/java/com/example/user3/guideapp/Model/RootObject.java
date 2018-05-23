package com.example.user3.guideapp.Model;

import java.util.List;

public class RootObject {
    public Boolean Status ;

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public List<HomeData.DataCourse> getDataCourse() {
        return dataCourse;
    }

    public void setDataCourse(List<HomeData.DataCourse> dataCourse) {
        this.dataCourse = dataCourse;
    }

    public String Message;
    public List<HomeData.DataCourse> dataCourse ;


    // public List<DataRating> dataRating;
    // public List<object> datalicense ;
    // public List<DataCourseBanner> dataCourseBanner ;
}
