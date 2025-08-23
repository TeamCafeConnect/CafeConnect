package com.yash.cafeconnect.entity;

public class Items {

    private int itemId;
    private int itemQuantity;
    private long price;
    private int menuId;
    private String description;

    public Items(){

    }

    public Items(int itemId, int itemQuantity, long price, int menuId, String description) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.price = price;
        this.menuId = menuId;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


