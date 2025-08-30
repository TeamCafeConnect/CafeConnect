package com.yash.cafeconnect.entity;
import com.yash.cafeconnect.entity.enums.TransactionStatus;

import java.time.Instant;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private double amount;
    private String paymentMethod;
    private TransactionStatus transactionStatus;
    private Instant timeStamp;
    private String userEmailId;
    private int itemId;
    private int orderId;

    public Transaction() {
    }

    public Transaction(int transactionId, double amount, String paymentMethod, TransactionStatus transactionStatus, Instant timeStamp, String userEmailId, int itemId, int orderId){
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionStatus = transactionStatus;
        this.timeStamp = timeStamp;
        this.userEmailId = userEmailId;
        this.itemId = itemId;
        this.orderId = orderId;

    }

    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserEmailId() {
        return userEmailId;
    }
    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
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

}
