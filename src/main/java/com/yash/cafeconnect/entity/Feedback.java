package com.yash.cafeconnect.entity;

import java.util.Date;

public class Feedback {
    private int feedbackId;
    private String userEmailId;
    private String content;
    private Date date;
    private int itemId;
    private int orderId;
    private int rating;

    public Feedback() {
    }

    public Feedback(int feedbackId, String userEmailId, String content, Date date, int itemId, int orderId, int rating) {
        this.feedbackId = feedbackId;
        this.userEmailId = userEmailId;
        this.content = content;
        this.date = date;
        this.itemId = itemId;
        this.orderId = orderId;
        this.rating = rating;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
