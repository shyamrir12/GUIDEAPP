package com.example.user3.guideapp.Model;

import java.util.List;

public class TrackingData {
    public class Coursecontant
    {
        public int ContentID ;
        public String ContentTitle ;
        public String ContentType ;
        public int EstimatedTime ;
        public String InstructorID ;
        public String ContentURL ;
        public String ContentDescription ;
        public String FileName ;
        public String FileContentType ;
        public int MappingID ;
        public String CourseID ;
        public String CourseName ;
        public int WeekID ;
        public String WeekName ;
        public int TopicID ;
        public String TopicName ;

        public int getContentID() {
            return ContentID;
        }

        public void setContentID(int contentID) {
            ContentID = contentID;
        }

        public String getContentTitle() {
            return ContentTitle;
        }

        public void setContentTitle(String contentTitle) {
            ContentTitle = contentTitle;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String contentType) {
            ContentType = contentType;
        }

        public int getEstimatedTime() {
            return EstimatedTime;
        }

        public void setEstimatedTime(int estimatedTime) {
            EstimatedTime = estimatedTime;
        }

        public String getInstructorID() {
            return InstructorID;
        }

        public void setInstructorID(String instructorID) {
            InstructorID = instructorID;
        }

        public String getContentURL() {
            return ContentURL;
        }

        public void setContentURL(String contentURL) {
            ContentURL = contentURL;
        }

        public String getContentDescription() {
            return ContentDescription;
        }

        public void setContentDescription(String contentDescription) {
            ContentDescription = contentDescription;
        }

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String fileName) {
            FileName = fileName;
        }

        public String getFileContentType() {
            return FileContentType;
        }

        public void setFileContentType(String fileContentType) {
            FileContentType = fileContentType;
        }

        public int getMappingID() {
            return MappingID;
        }

        public void setMappingID(int mappingID) {
            MappingID = mappingID;
        }

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

        public int getWeekID() {
            return WeekID;
        }

        public void setWeekID(int weekID) {
            WeekID = weekID;
        }

        public String getWeekName() {
            return WeekName;
        }

        public void setWeekName(String weekName) {
            WeekName = weekName;
        }

        public int getTopicID() {
            return TopicID;
        }

        public void setTopicID(int topicID) {
            TopicID = topicID;
        }

        public String getTopicName() {
            return TopicName;
        }

        public void setTopicName(String topicName) {
            TopicName = topicName;
        }
    }

    public class Week
    {
        public int WeekID ;
        public String WeekName ;

        public int getWeekID() {
            return WeekID;
        }

        public void setWeekID(int weekID) {
            WeekID = weekID;
        }

        public String getWeekName() {
            return WeekName;
        }

        public void setWeekName(String weekName) {
            WeekName = weekName;
        }
    }

    public class Course
    {
        public String CategoryMaster ;
        public String InstructorProfile ;
        public String CourseID ;
        public String CourseName ;
        public String CourseDescription ;
        public String Keyword ;
        public int CourseStatus ;
        public double CoursePrice ;
        public String DiscountedPrice ;
        public String Currency ;
        public String InstructorID ;
        public int CategoryID ;
        public String LectureType ;
        public String UpdatedBy ;
        public String UpdatedOn ;
        public String PublishedOn ;

        public String getCategoryMaster() {
            return CategoryMaster;
        }

        public void setCategoryMaster(String categoryMaster) {
            CategoryMaster = categoryMaster;
        }

        public String getInstructorProfile() {
            return InstructorProfile;
        }

        public void setInstructorProfile(String instructorProfile) {
            InstructorProfile = instructorProfile;
        }

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

        public String getDiscountedPrice() {
            return DiscountedPrice;
        }

        public void setDiscountedPrice(String discountedPrice) {
            DiscountedPrice = discountedPrice;
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

        public String getLectureType() {
            return LectureType;
        }

        public void setLectureType(String lectureType) {
            LectureType = lectureType;
        }

        public String getUpdatedBy() {
            return UpdatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            UpdatedBy = updatedBy;
        }

        public String getUpdatedOn() {
            return UpdatedOn;
        }

        public void setUpdatedOn(String updatedOn) {
            UpdatedOn = updatedOn;
        }

        public String getPublishedOn() {
            return PublishedOn;
        }

        public void setPublishedOn(String publishedOn) {
            PublishedOn = publishedOn;
        }
    }

    public class Topic
    {
        public Course Course ;
        public String WeekMaster ;
        public int TopicID ;
        public String TopicName ;
        public String TopicDescription ;
        public int WeekID ;
        public String CourseID ;

        public TrackingData.Course getCourse() {
            return Course;
        }

        public void setCourse(TrackingData.Course course) {
            Course = course;
        }

        public String getWeekMaster() {
            return WeekMaster;
        }

        public void setWeekMaster(String weekMaster) {
            WeekMaster = weekMaster;
        }

        public int getTopicID() {
            return TopicID;
        }

        public void setTopicID(int topicID) {
            TopicID = topicID;
        }

        public String getTopicName() {
            return TopicName;
        }

        public void setTopicName(String topicName) {
            TopicName = topicName;
        }

        public String getTopicDescription() {
            return TopicDescription;
        }

        public void setTopicDescription(String topicDescription) {
            TopicDescription = topicDescription;
        }

        public int getWeekID() {
            return WeekID;
        }

        public void setWeekID(int weekID) {
            WeekID = weekID;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }
    }
    public class Learnercoursecontant
    {
        public int ContentMapId ;

        public String CourseID ;

        public int WeekID ;

        public int TopicID ;

        public int ContentID ;

        public String LearnerID ;

        public boolean Status ;

        public String UpdatedOn ;

        public String WeekName ;

        public String TopicName ;

        public String ContentTitle ;

        public String ContentType ;

        public int EstimatedTime ;

        public String ContentURL ;

        public String ContentDescription ;

        public int getContentMapId() {
            return ContentMapId;
        }

        public void setContentMapId(int contentMapId) {
            ContentMapId = contentMapId;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }

        public int getWeekID() {
            return WeekID;
        }

        public void setWeekID(int weekID) {
            WeekID = weekID;
        }

        public int getTopicID() {
            return TopicID;
        }

        public void setTopicID(int topicID) {
            TopicID = topicID;
        }

        public int getContentID() {
            return ContentID;
        }

        public void setContentID(int contentID) {
            ContentID = contentID;
        }

        public String getLearnerID() {
            return LearnerID;
        }

        public void setLearnerID(String learnerID) {
            LearnerID = learnerID;
        }

        public boolean isStatus() {
            return Status;
        }

        public void setStatus(boolean status) {
            Status = status;
        }

        public String getUpdatedOn() {
            return UpdatedOn;
        }

        public void setUpdatedOn(String updatedOn) {
            UpdatedOn = updatedOn;
        }

        public String getWeekName() {
            return WeekName;
        }

        public void setWeekName(String weekName) {
            WeekName = weekName;
        }

        public String getTopicName() {
            return TopicName;
        }

        public void setTopicName(String topicName) {
            TopicName = topicName;
        }

        public String getContentTitle() {
            return ContentTitle;
        }

        public void setContentTitle(String contentTitle) {
            ContentTitle = contentTitle;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String contentType) {
            ContentType = contentType;
        }

        public int getEstimatedTime() {
            return EstimatedTime;
        }

        public void setEstimatedTime(int estimatedTime) {
            EstimatedTime = estimatedTime;
        }

        public String getContentURL() {
            return ContentURL;
        }

        public void setContentURL(String contentURL) {
            ContentURL = contentURL;
        }

        public String getContentDescription() {
            return ContentDescription;
        }

        public void setContentDescription(String contentDescription) {
            ContentDescription = contentDescription;
        }
    }

    public class RootObject
    {
        public boolean Status ;
        public String Message ;
        public List<Coursecontant> coursecontant ;
        public List<Week> week ;
        public List<Topic> topic ;
        public List<Learnercoursecontant> learnercoursecontant ;
        public String UserId ;
        public String CourseName ;
        public String LactureType ;
        public String date ;
        public double percent ;

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

        public List<Coursecontant> getCoursecontant() {
            return coursecontant;
        }

        public void setCoursecontant(List<Coursecontant> coursecontant) {
            this.coursecontant = coursecontant;
        }

        public List<Week> getWeek() {
            return week;
        }

        public void setWeek(List<Week> week) {
            this.week = week;
        }

        public List<Topic> getTopic() {
            return topic;
        }

        public void setTopic(List<Topic> topic) {
            this.topic = topic;
        }

        public List<Learnercoursecontant> getLearnercoursecontant() {
            return learnercoursecontant;
        }

        public void setLearnercoursecontant(List<Learnercoursecontant> learnercoursecontant) {
            this.learnercoursecontant = learnercoursecontant;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getCourseName() {
            return CourseName;
        }

        public void setCourseName(String courseName) {
            CourseName = courseName;
        }

        public String getLactureType() {
            return LactureType;
        }

        public void setLactureType(String lactureType) {
            LactureType = lactureType;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }
    }
}
