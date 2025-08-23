package com.yash.cafeconnect.entity;


public class Menu {
    private int menuId;
    private int cafeId;
     private int dishName;
     private long price;
     private String description;
     private int itemId;

     public Menu(){

     }
    public Menu(int menuId, int cafeId, int dishName, long price, String description, int itemId) {
        this.menuId = menuId;
        this.cafeId = cafeId;
        this.dishName = dishName;
        this.price = price;
        this.description = description;
        this.itemId = itemId;
    }




    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getCafeId() {
        return cafeId;
    }

    public void setCafeId(int cafeId) {
        this.cafeId = cafeId;
    }

    public int getDishName() {
        return dishName;
    }

    public void setDishName(int dishName) {
        this.dishName = dishName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
