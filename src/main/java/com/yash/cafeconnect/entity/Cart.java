package com.yash.cafeconnect.entity;

public class Cart {

    private int itemId;
    private int itemQuantity;
    private float totalAmount;
    private int orderId;
    private String userEmailId;
    private int cartId;

    public Cart(){}

    public Cart(int itemId, int itemQuantity, float totalAmount, int orderId, String userEmailId, int cartId) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.totalAmount = totalAmount;
        this.orderId = orderId;
        this.userEmailId = userEmailId;
        this.cartId = cartId;
    }

    public int getItemId(){
        return itemId;
    }
     public void setItemId(int itemId){
        this.itemId = itemId;
     }

     public int getItemQuantity(){
        return itemQuantity;
     }
     public void setItemQuantity(int itemQuantity){
        this.itemQuantity = itemQuantity;
     }

     public float getTotalAmount(){
        return totalAmount;
     }
     public void setTotalAmount(float totalAmount){
        this.totalAmount = totalAmount;
     }

     public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public String getUserEmailId(){
        return userEmailId;
    }
    public void setUserEmailId(String userEmailId){
        this.userEmailId = userEmailId;
    }

    public int getCartId(){
        return cartId;
    }
    public void setCartId(int cartId){
        this.cartId = cartId;
    }
}
