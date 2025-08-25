package com.yash.cafeconnect.entity;

import java.util.Date;

public class UserFoodPooling {
    private int poolingId;
    private String dishName;
    private int ownerId;
    private int receiverId;
    private Date createdAt;

    public UserFoodPooling(){}

    public UserFoodPooling(int poolingId, String dishName, int ownerId, int receiverId, Date createdAt){
        this.poolingId = poolingId;
        this.dishName = dishName;
        this.ownerId = ownerId;
        this.receiverId = receiverId;
        this.createdAt = createdAt;
    }

    public int getPoolingI(){
        return poolingId;
    }
    public void setPoolingId(int poolingId){
        this.poolingId = poolingId;
    }

    public String getDishName(){
        return dishName;
    }
    public void setDishName(String dishName){
        this.dishName = dishName;
    }

    public int getOwnerId(){
        return ownerId;
    }
    public void setOwnerId(int ownerId){
        this.ownerId = ownerId;
    }

    public int getReceiverId(){
        return receiverId;
    }
    public void setReceiverId(int receiverId){
        this.receiverId = receiverId;
    }

    public Date getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
}
