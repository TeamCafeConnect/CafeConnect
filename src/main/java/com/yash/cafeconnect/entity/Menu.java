package com.yash.cafeconnect.entity;


public class Menu {
    private int menuId;
    private int cafeId;
     private String dishName;
     private double price;
     private String description;
     private int itemId;

     public Menu(){

     }
    public Menu(int menuId, int cafeId, String dishName, double price, String description, int itemId) {
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

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
