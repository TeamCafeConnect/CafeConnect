package com.yash.cafeconnect.entity;


import com.yash.cafeconnect.entity.enums.UserRoles;
public class User {

    private String userEmailId;
    private String name;
    private String mobileNo;
    private String password;
    private int officeId;
    private UserRoles userRoles;

    public User(String userEmailId, String name, String mobileNo, String password, int officeId, UserRoles userRoles) {
        this.userEmailId = userEmailId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
        this.officeId = officeId;
        this.userRoles = userRoles;
    }

    public String getUserEmailId() {
        return userEmailId;
    }
    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
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
}
