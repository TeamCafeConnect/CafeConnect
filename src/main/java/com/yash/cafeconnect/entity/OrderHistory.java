package com.yash.cafeconnect.entity;

import java.time.Instant;

public class OrderHistory {
    private int orderId;
    private String userEmailId;
    private float totalAmount;
    private Instant orderTime;

    public OrderHistory() {
    }

    public OrderHistory(int orderId, String userEmailId, float totalAmount, Instant orderTime) {
        this.orderId = orderId;
        this.userEmailId = userEmailId;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Instant getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Instant orderTime) {
        this.orderTime = orderTime;
    }
}

