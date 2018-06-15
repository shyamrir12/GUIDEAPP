package com.example.user3.guideapp.Model;

public class CartData {
    public class DatacourseDetails
    {
        public String CourseID ;
        public String CourseName ;
        public String CourseDescription ;
        public String Keyword ;
        public int CourseStatus ;
        public double CoursePrice ;
        public String Currency ;
        public String InstructorID ;
        public int CategoryID ;
        public String CategoryName ;
        public String InstructorName ;
        public String ColorCategory ;
        public String SpanColor ;
        public String LectureType ;
        public int Batch1StartDayOfMonth ;
        public int Batch2StartDayOfMonth ;
        public int Batch3StartDayOfMonth ;
        public int Batch4StartDayOfMonth ;
        public int Duration ;
        public String BgColor ;
        public String HexCodes ;
        public String PublishedOn ;
        public Boolean Status ;

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

        public Boolean getStatus() {
            return Status;
        }

        public void setStatus(Boolean status) {
            Status = status;
        }
    }

    public class Dataduration
    {
        public String Course ;
        public int WeekSheduleId ;
        public int Duration ;
        public int Batch1StartDayOfMonth ;
        public int Batch2StartDayOfMonth ;
        public int Batch3StartDayOfMonth ;
        public int Batch4StartDayOfMonth ;
        public String CourseID ;
        public String UpdatedOn ;

        public String getCourse() {
            return Course;
        }

        public void setCourse(String course) {
            Course = course;
        }

        public int getWeekSheduleId() {
            return WeekSheduleId;
        }

        public void setWeekSheduleId(int weekSheduleId) {
            WeekSheduleId = weekSheduleId;
        }

        public int getDuration() {
            return Duration;
        }

        public void setDuration(int duration) {
            Duration = duration;
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

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }

        public String getUpdatedOn() {
            return UpdatedOn;
        }

        public void setUpdatedOn(String updatedOn) {
            UpdatedOn = updatedOn;
        }
    }

    public class RootObject
    {
        public String UserId ;
        public int Duration ;
        public String CourseUrl ;
        public String CourseID ;
        public Boolean Subscription ;
        public String LectureType ;
        public DatacourseDetails datacourseDetails ;
        public Dataduration dataduration ;

        public String OngoingBatch ;
        public String OngoingBatchSD ;
        public String OngoingBatchED ;

        public String getOngoingBatch() {
            return OngoingBatch;
        }

        public void setOngoingBatch(String ongoingBatch) {
            OngoingBatch = ongoingBatch;
        }

        public String getOngoingBatchSD() {
            return OngoingBatchSD;
        }

        public void setOngoingBatchSD(String ongoingBatchSD) {
            OngoingBatchSD = ongoingBatchSD;
        }

        public String getOngoingBatchED() {
            return OngoingBatchED;
        }

        public void setOngoingBatchED(String ongoingBatchED) {
            OngoingBatchED = ongoingBatchED;
        }

        public String getUpcomingBatch() {
            return UpcomingBatch;
        }

        public void setUpcomingBatch(String upcomingBatch) {
            UpcomingBatch = upcomingBatch;
        }

        public String getUpcomingBatchSD() {
            return UpcomingBatchSD;
        }

        public void setUpcomingBatchSD(String upcomingBatchSD) {
            UpcomingBatchSD = upcomingBatchSD;
        }

        public String getUpcomingBatchED() {
            return UpcomingBatchED;
        }

        public void setUpcomingBatchED(String upcomingBatchED) {
            UpcomingBatchED = upcomingBatchED;
        }

        public String UpcomingBatch;
        public String UpcomingBatchSD ;
        public String UpcomingBatchED ;

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public int getDuration() {
            return Duration;
        }

        public void setDuration(int duration) {
            Duration = duration;
        }

        public String getCourseUrl() {
            return CourseUrl;
        }

        public void setCourseUrl(String courseUrl) {
            CourseUrl = courseUrl;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }

        public Boolean getSubscription() {
            return Subscription;
        }

        public void setSubscription(Boolean subscription) {
            Subscription = subscription;
        }

        public String getLectureType() {
            return LectureType;
        }

        public void setLectureType(String lectureType) {
            LectureType = lectureType;
        }

        public DatacourseDetails getDatacourseDetails() {
            return datacourseDetails;
        }

        public void setDatacourseDetails(DatacourseDetails datacourseDetails) {
            this.datacourseDetails = datacourseDetails;
        }

        public Dataduration getDataduration() {
            return dataduration;
        }

        public void setDataduration(Dataduration dataduration) {
            this.dataduration = dataduration;
        }
    }
}
