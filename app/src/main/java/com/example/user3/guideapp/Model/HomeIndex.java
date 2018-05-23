package com.example.user3.guideapp.Model;

import java.util.List;

public class HomeIndex {
    public class DataCourseList
    {
        public String CourseID ;

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }

        public String getCourseName() {
            return CourseName;
        }

        public void setCourseName(String courseName) {
            CourseName = courseName;
        }

        public String getCourseDescription() {
            return CourseDescription;
        }

        public void setCourseDescription(String courseDescription) {
            CourseDescription = courseDescription;
        }

        public String getKeyword() {
            return Keyword;
        }

        public void setKeyword(String keyword) {
            Keyword = keyword;
        }

        public int getCourseStatus() {
            return CourseStatus;
        }

        public void setCourseStatus(int courseStatus) {
            CourseStatus = courseStatus;
        }

        public double getCoursePrice() {
            return CoursePrice;
        }

        public void setCoursePrice(double coursePrice) {
            CoursePrice = coursePrice;
        }

        public String getCurrency() {
            return Currency;
        }

        public void setCurrency(String currency) {
            Currency = currency;
        }

        public String getInstructorID() {
            return InstructorID;
        }

        public void setInstructorID(String instructorID) {
            InstructorID = instructorID;
        }

        public int getCategoryID() {
            return CategoryID;
        }

        public void setCategoryID(int categoryID) {
            CategoryID = categoryID;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String categoryName) {
            CategoryName = categoryName;
        }

        public String getInstructorName() {
            return InstructorName;
        }

        public void setInstructorName(String instructorName) {
            InstructorName = instructorName;
        }

        public String getColorCategory() {
            return ColorCategory;
        }

        public void setColorCategory(String colorCategory) {
            ColorCategory = colorCategory;
        }

        public String getSpanColor() {
            return SpanColor;
        }

        public void setSpanColor(String spanColor) {
            SpanColor = spanColor;
        }

        public String getLectureType() {
            return LectureType;
        }

        public void setLectureType(String lectureType) {
            LectureType = lectureType;
        }

        public int getBatch1StartDayOfMonth() {
            return Batch1StartDayOfMonth;
        }

        public void setBatch1StartDayOfMonth(int batch1StartDayOfMonth) {
            Batch1StartDayOfMonth = batch1StartDayOfMonth;
        }

        public int getBatch2StartDayOfMonth() {
            return Batch2StartDayOfMonth;
        }

        public void setBatch2StartDayOfMonth(int batch2StartDayOfMonth) {
            Batch2StartDayOfMonth = batch2StartDayOfMonth;
        }

        public int getBatch3StartDayOfMonth() {
            return Batch3StartDayOfMonth;
        }

        public void setBatch3StartDayOfMonth(int batch3StartDayOfMonth) {
            Batch3StartDayOfMonth = batch3StartDayOfMonth;
        }

        public int getBatch4StartDayOfMonth() {
            return Batch4StartDayOfMonth;
        }

        public void setBatch4StartDayOfMonth(int batch4StartDayOfMonth) {
            Batch4StartDayOfMonth = batch4StartDayOfMonth;
        }

        public int getDuration() {
            return Duration;
        }

        public void setDuration(int duration) {
            Duration = duration;
        }

        public String getBgColor() {
            return BgColor;
        }

        public void setBgColor(String bgColor) {
            BgColor = bgColor;
        }

        public String getHexCodes() {
            return HexCodes;
        }

        public void setHexCodes(String hexCodes) {
            HexCodes = hexCodes;
        }

        public String getPublishedOn() {
            return PublishedOn;
        }

        public void setPublishedOn(String publishedOn) {
            PublishedOn = publishedOn;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public String CourseName;
        public String CourseDescription;
        public String Keyword ;
        public int CourseStatus;
        public double CoursePrice;
        public String Currency ;
        public String InstructorID ;
        public int CategoryID;
        public String CategoryName ;
        public String InstructorName;
        public String ColorCategory ;
        public String SpanColor ;
        public String LectureType ;
        public int Batch1StartDayOfMonth ;
        public int Batch2StartDayOfMonth;
        public int Batch3StartDayOfMonth ;
        public int Batch4StartDayOfMonth ;
        public int Duration ;
        public String BgColor ;
        public String HexCodes;
        public String PublishedOn ;
        public String Status;
    }

    public class DataCategoryList
    {
        public int CategoryID ;

        public int getCategoryID() {
            return CategoryID;
        }

        public void setCategoryID(int categoryID) {
            CategoryID = categoryID;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String categoryName) {
            CategoryName = categoryName;
        }

        public int getCourseCount() {
            return CourseCount;
        }

        public void setCourseCount(int courseCount) {
            CourseCount = courseCount;
        }

        public String getColorCategory() {
            return ColorCategory;
        }

        public void setColorCategory(String colorCategory) {
            ColorCategory = colorCategory;
        }

        public String getSpanColor() {
            return SpanColor;
        }

        public void setSpanColor(String spanColor) {
            SpanColor = spanColor;
        }

        public String getBgColor() {
            return BgColor;
        }

        public void setBgColor(String bgColor) {
            BgColor = bgColor;
        }

        public String getHexCodes() {
            return HexCodes;
        }

        public void setHexCodes(String hexCodes) {
            HexCodes = hexCodes;
        }

        public String CategoryName ;
        public int CourseCount ;
        public String ColorCategory;
        public String SpanColor;
        public String BgColor ;
        public String HexCodes ;
    }

    public class HomeIndexResult
    {
        public boolean isStatus() {
            return Status;
        }

        public void setStatus(boolean status) {
            Status = status;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        public List<DataCourseList> getDataCourseList() {
            return dataCourseList;
        }

        public void setDataCourseList(List<DataCourseList> dataCourseList) {
            this.dataCourseList = dataCourseList;
        }

        public List<DataCategoryList> getDataCategoryList() {
            return dataCategoryList;
        }

        public void setDataCategoryList(List<DataCategoryList> dataCategoryList) {
            this.dataCategoryList = dataCategoryList;
        }

        public boolean Status ;
        public String Message;
        public List<DataCourseList> dataCourseList;
        public List<DataCategoryList> dataCategoryList ;
    }
}
