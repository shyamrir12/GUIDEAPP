package com.example.user3.guideapp.Model;

import java.util.List;

public class SeeMoreData {
    public class Datacourselist
    {
        public String  CourseID ;
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
        public int AvrageRating;
        public boolean SubscriptionStatus;

        public boolean isSubscriptionStatus() {
            return SubscriptionStatus;
        }

        public void setSubscriptionStatus(boolean subscriptionStatus) {
            SubscriptionStatus = subscriptionStatus;
        }

        public int getAvrageRating() {
            return AvrageRating;
        }

        public void setAvrageRating(int avrageRating) {
            AvrageRating = avrageRating;
        }

        public int getFileId() {
            return FileId;
        }

        public void setFileId(int fileId) {
            FileId = fileId;
        }

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String fileName) {
            FileName = fileName;
        }

        public int FileId ;

        public String FileName ;
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

    public class Dataavragecourserating
    {
        public int AvrageRating ;
        public String CourseID ;

        public int getAvrageRating() {
            return AvrageRating;
        }

        public void setAvrageRating(int avrageRating) {
            AvrageRating = avrageRating;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }
    }

    public class Datacoursebanner
    {
        public String Course ;
        public int FileId ;
        public String CourseID ;
        public String FileName ;
        public String ContentType ;
        public int UploadType ;

        public String getCourse() {
            return Course;
        }

        public void setCourse(String course) {
            Course = course;
        }

        public int getFileId() {
            return FileId;
        }

        public void setFileId(int fileId) {
            FileId = fileId;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String fileName) {
            FileName = fileName;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String contentType) {
            ContentType = contentType;
        }

        public int getUploadType() {
            return UploadType;
        }

        public void setUploadType(int uploadType) {
            UploadType = uploadType;
        }
    }
    public class Datalearnersubscription
    {
        public String LearnerID ;
        public String CourseID ;
        public String SubscriptionDate ;
        public String CourseStartDate ;
        public boolean SubscriptionStatus;

        public String getLearnerID() {
            return LearnerID;
        }

        public void setLearnerID(String learnerID) {
            LearnerID = learnerID;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }

        public String getSubscriptionDate() {
            return SubscriptionDate;
        }

        public void setSubscriptionDate(String subscriptionDate) {
            SubscriptionDate = subscriptionDate;
        }

        public String getCourseStartDate() {
            return CourseStartDate;
        }

        public void setCourseStartDate(String courseStartDate) {
            CourseStartDate = courseStartDate;
        }

        public boolean isSubscriptionStatus() {
            return SubscriptionStatus;
        }

        public void setSubscriptionStatus(boolean subscriptionStatus) {
            SubscriptionStatus = subscriptionStatus;
        }
    }

    public class RootObject
    {
        public List<Datacourselist> datacourselist ;
        public List<Dataavragecourserating> dataavragecourserating ;
        public List<Datalearnersubscription> datalearnersubscription ;
        public List<Datacoursebanner> datacoursebanner ;

        public List<Datacourselist> getDatacourselist() {
            return datacourselist;
        }

        public void setDatacourselist(List<Datacourselist> datacourselist) {
            this.datacourselist = datacourselist;
        }

        public List<Dataavragecourserating> getDataavragecourserating() {
            return dataavragecourserating;
        }

        public void setDataavragecourserating(List<Dataavragecourserating> dataavragecourserating) {
            this.dataavragecourserating = dataavragecourserating;
        }

        public List<Datalearnersubscription> getDatalearnersubscription() {
            return datalearnersubscription;
        }

        public void setDatalearnersubscription(List<Datalearnersubscription> datalearnersubscription) {
            this.datalearnersubscription = datalearnersubscription;
        }

        public List<Datacoursebanner> getDatacoursebanner() {
            return datacoursebanner;
        }

        public void setDatacoursebanner(List<Datacoursebanner> datacoursebanner) {
            this.datacoursebanner = datacoursebanner;
        }
    }
}
