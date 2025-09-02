package com.yash.cafeconnect.entity;


public class Menu {

     private int itemId;
     private int menuId;
     private int cafeId;
     private String menuName;
     private String description;

     public Menu(){

     }
    public Menu(int menuId, int cafeId,  String description) {
        this.menuId = menuId;
        this.cafeId = cafeId;
        this.description = description;
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
