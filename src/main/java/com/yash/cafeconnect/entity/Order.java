package com.yash.cafeconnect.entity;

public class Order {

    private int orderId;
    private String userEmailId;
    private String cafeId;
    private float totalAmount;

    public Order(int orderId, String userEmailId, String cafeId, float totalAmount)
    {
        this.orderId = orderId;
        this.userEmailId = userEmailId;
        this.cafeId = cafeId;
        this.totalAmount = totalAmount;

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
    public String getCafeId() {
        return cafeId;
    }
    public void setCafeId(String cafeId) {
        this.cafeId = cafeId;
    }
    public float getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
