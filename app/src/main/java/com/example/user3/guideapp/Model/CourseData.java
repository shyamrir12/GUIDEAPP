package com.example.user3.guideapp.Model;

import java.util.List;

public class CourseData {
    public class DataCourseFaq
    {
        public String Course ;
        public int QuestionID ;
        public String Question ;
        public String Answer ;
        public String CourseID ;

        public String getCourse() {
            return Course;
        }

        public void setCourse(String course) {
            Course = course;
        }

        public int getQuestionID() {
            return QuestionID;
        }

        public void setQuestionID(int questionID) {
            QuestionID = questionID;
        }

        public String getQuestion() {
            return Question;
        }

        public void setQuestion(String question) {
            Question = question;
        }

        public String getAnswer() {
            return Answer;
        }

        public void setAnswer(String answer) {
            Answer = answer;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }
    }

    public class Datacoursecontent
    {
        public int ContentID ;
        public String ContentTitle ;
        public String ContentType ;
        public int EstimatedTime ;
        public String InstructorID ;
        public String ContentURL ;
        public String ContentDescription;
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

    public class Dataweek
    {
        public int WeekID ;
        public String WeekName;

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

    public class Datatopic
    {
        public String Course ;
        public String WeekMaster ;
        public int TopicID ;
        public String TopicName ;
        public String TopicDescription ;
        public int WeekID ;
        public String CourseID ;

        public String getCourse() {
            return Course;
        }

        public void setCourse(String course) {
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

    public class Datacategorylist
    {
        public int CategoryID ;
        public String CategoryName ;
        public int CourseCount ;
        public String ColorCategory;
        public String SpanColor ;
        public String BgColor;
        public String HexCodes ;

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

    public class CourseDetails
    {
        public String CourseID ;
        public String CourseName ;
        public String CourseDescription;
        public String Keyword;
        public int CourseStatus;
        public double CoursePrice ;
        public String Currency ;
        public String InstructorID ;
        public int CategoryID;
        public String CategoryName;
        public String InstructorName;
        public String ColorCategory ;
        public String SpanColor;
        public String LectureType ;
        public int Batch1StartDayOfMonth;
        public int Batch2StartDayOfMonth ;
        public int Batch3StartDayOfMonth;
        public int Batch4StartDayOfMonth ;
        public int Duration;
        public String BgColor ;
        public String HexCodes ;
        public String PublishedOn;
        public String Status ;

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
    }

    public class CourseDataResult
    {
        public boolean Status ;
        public String Message ;
        public int totalSubscription ;
        public int totalLactures;
        public String UserId ;
        public String url ;
        public String CourseId ;
        public int totaltestimonial ;
        public String msg ;
        public String date ;
        public String startdate;
        public boolean status;
        public List<DataCourseFaq> dataCourseFaq ;
        public String datadiscussionforum;
        public String datacoursetestimonial ;
        public String dataforum;
        public String datareply;
        public String datacourseTestimonial ;
        public List<Datacoursecontent> datacoursecontent ;
        public List<Dataweek> dataweek;
        public List<Datatopic> datatopic ;
        public String datacoursemapping ;
        public List<Datacategorylist> datacategorylist;
        public String datacourseRating ;
        public Datacoursebanner datacoursebanner ;
        public CourseDetails CourseDetails ;

        public boolean isStatus() {
            return Status;
        }

        public void setStatus(boolean status) {
            Status = status;
        }

        public List<DataCourseFaq> getDataCourseFaq() {
            return dataCourseFaq;
        }

        public void setDataCourseFaq(List<DataCourseFaq> dataCourseFaq) {
            this.dataCourseFaq = dataCourseFaq;
        }

        public String getDatadiscussionforum() {
            return datadiscussionforum;
        }

        public void setDatadiscussionforum(String datadiscussionforum) {
            this.datadiscussionforum = datadiscussionforum;
        }

        public String getDatacoursetestimonial() {
            return datacoursetestimonial;
        }

        public void setDatacoursetestimonial(String datacoursetestimonial) {
            this.datacoursetestimonial = datacoursetestimonial;
        }

        public String getDataforum() {
            return dataforum;
        }

        public void setDataforum(String dataforum) {
            this.dataforum = dataforum;
        }

        public String getDatareply() {
            return datareply;
        }

        public void setDatareply(String datareply) {
            this.datareply = datareply;
        }

        public String getDatacourseTestimonial() {
            return datacourseTestimonial;
        }

        public void setDatacourseTestimonial(String datacourseTestimonial) {
            this.datacourseTestimonial = datacourseTestimonial;
        }

        public List<Datacoursecontent> getDatacoursecontent() {
            return datacoursecontent;
        }

        public void setDatacoursecontent(List<Datacoursecontent> datacoursecontent) {
            this.datacoursecontent = datacoursecontent;
        }

        public List<Dataweek> getDataweek() {
            return dataweek;
        }

        public void setDataweek(List<Dataweek> dataweek) {
            this.dataweek = dataweek;
        }

        public List<Datatopic> getDatatopic() {
            return datatopic;
        }

        public void setDatatopic(List<Datatopic> datatopic) {
            this.datatopic = datatopic;
        }

        public String getDatacoursemapping() {
            return datacoursemapping;
        }

        public void setDatacoursemapping(String datacoursemapping) {
            this.datacoursemapping = datacoursemapping;
        }

        public List<Datacategorylist> getDatacategorylist() {
            return datacategorylist;
        }

        public void setDatacategorylist(List<Datacategorylist> datacategorylist) {
            this.datacategorylist = datacategorylist;
        }

        public String getDatacourseRating() {
            return datacourseRating;
        }

        public void setDatacourseRating(String datacourseRating) {
            this.datacourseRating = datacourseRating;
        }

        public Datacoursebanner getDatacoursebanner() {
            return datacoursebanner;
        }

        public void setDatacoursebanner(Datacoursebanner datacoursebanner) {
            this.datacoursebanner = datacoursebanner;
        }

        public CourseData.CourseDetails getCourseDetails() {
            return CourseDetails;
        }

        public void setCourseDetails(CourseData.CourseDetails courseDetails) {
            CourseDetails = courseDetails;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        public int getTotalSubscription() {
            return totalSubscription;
        }

        public void setTotalSubscription(int totalSubscription) {
            this.totalSubscription = totalSubscription;
        }

        public int getTotalLactures() {
            return totalLactures;
        }

        public void setTotalLactures(int totalLactures) {
            this.totalLactures = totalLactures;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCourseId() {
            return CourseId;
        }

        public void setCourseId(String courseId) {
            CourseId = courseId;
        }

        public int getTotaltestimonial() {
            return totaltestimonial;
        }

        public void setTotaltestimonial(int totaltestimonial) {
            this.totaltestimonial = totaltestimonial;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStartdate() {
            return startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }
    }
}
