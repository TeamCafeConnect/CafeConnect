package com.yash.cafeconnect.entity;

public class Tokenization {
    private int tokenId;
    private String userEmailId;
    private int cartId;

    public Tokenization(){

    }

    public Tokenization(int tokenId, String userEmailId, int cartId) {
        this.tokenId = tokenId;
        this.userEmailId = userEmailId;
        this.cartId = cartId;
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
