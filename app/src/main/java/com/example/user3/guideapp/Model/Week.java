package com.example.user3.guideapp.Model;

public class Week {
    private int WeekID;
    private String WeekName;

    public int getWeekID() {
        return WeekID;
    }

    public String getWeekName() {
        return WeekName;
    }

    public void setWeekID(int weekID) {
        WeekID = weekID;
    }

    public void setWeekName(String weekName) {
        WeekName = weekName;
    }

    public Week(int weekID, String weekName) {

        WeekID = weekID;
        WeekName = weekName;

    }
}
