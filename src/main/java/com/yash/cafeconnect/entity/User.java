package com.yash.cafeconnect.entity;


import com.yash.cafeconnect.entity.enums.UserRoles;
public class User {

    private String emailId;
    private String name;
    private String mobileNo;
    private String password;
    private int officeId;
    private UserRoles userRoles;

    public User() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    public User(String emailId, String name, String mobileNo, String password, int officeId, UserRoles userRoles) {
        this.emailId = emailId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
        this.officeId = officeId;
        this.userRoles = userRoles;


    }
}
