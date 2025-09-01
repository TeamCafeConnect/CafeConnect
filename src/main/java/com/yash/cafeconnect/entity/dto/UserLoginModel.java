package com.yash.cafeconnect.entity.dto;

import com.yash.cafeconnect.entity.User;

public class UserLoginModel {
    private User user;
    private String message;

    public UserLoginModel(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public UserLoginModel() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
