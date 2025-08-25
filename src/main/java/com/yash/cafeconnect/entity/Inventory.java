package com.yash.cafeconnect.entity;

public class Inventory {

    private int materialId;
    private String cafeName;
    private int quantityAvailable;
    private int unitMeasurement;


    public Inventory(){

    }

    public Inventory(int materialId, String cafeName, int quantityAvailable, int unitMeasurement) {
        this.materialId = materialId;
        this.cafeName = cafeName;
        this.quantityAvailable = quantityAvailable;
        this.unitMeasurement = unitMeasurement;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(int unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }
}
