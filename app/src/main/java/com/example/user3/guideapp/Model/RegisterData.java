package com.example.user3.guideapp.Model;

import java.util.List;

public class RegisterData {
    public class Dataregister
    {
        public String UserName ;
        public String Email ;
        public String Password ;
        public String ConfirmPassword ;
        public String PhoneNumber ;
        public String Role ;
        public String CourseID ;

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public String getConfirmPassword() {
            return ConfirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            ConfirmPassword = confirmPassword;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
        }

        public String getRole() {
            return Role;
        }

        public void setRole(String role) {
            Role = role;
        }

        public String getCourseID() {
            return CourseID;
        }

        public void setCourseID(String courseID) {
            CourseID = courseID;
        }
    }

    public class DataIdentityResult
    {
        public Boolean Succeeded ;
        public List<String> Errors ;

        public Boolean getSucceeded() {
            return Succeeded;
        }

        public void setSucceeded(Boolean succeeded) {
            Succeeded = succeeded;
        }

        public List<String> getErrors() {
            return Errors;
        }

        public void setErrors(List<String> errors) {
            Errors = errors;
        }
    }

    public class RootObject
    {
        public String Message ;
        public String  Result ;
        public Dataregister dataregister ;
        public DataIdentityResult dataIdentityResult ;

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String result) {
            Result = result;
        }

        public Dataregister getDataregister() {
            return dataregister;
        }

        public void setDataregister(Dataregister dataregister) {
            this.dataregister = dataregister;
        }

        public DataIdentityResult getDataIdentityResult() {
            return dataIdentityResult;
        }

        public void setDataIdentityResult(DataIdentityResult dataIdentityResult) {
            this.dataIdentityResult = dataIdentityResult;
        }
    }
}
