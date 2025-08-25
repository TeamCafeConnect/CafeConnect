package com.yash.cafeconnect.entity;

public class Tokenization {
    private int TokenId;
    private String UserEmailId;
    private int CartId;

    public Tokenization(){

    }

    public Tokenization(int tokenId, String userEmailId, int cartId) {
        TokenId = tokenId;
        UserEmailId = userEmailId;
        CartId = cartId;
    }

    public int getTokenId() {
        return TokenId;
    }

    public void setTokenId(int tokenId) {
        TokenId = tokenId;
    }

    public String getUserEmailId() {
        return UserEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        UserEmailId = userEmailId;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }
}
