package com.yash.cafeconnect.entity;

public class Inventory {

    private int MaterialId;
    private String CafeName;
    private int QuantityAvailable;
    private int UnitMeasurement;

    public Inventory(int materialId, String cafeName, int quantityAvailable, int unitMeasurement) {
        MaterialId = materialId;
        CafeName = cafeName;
        QuantityAvailable = quantityAvailable;
        UnitMeasurement = unitMeasurement;
    }

    public Inventory(){

    }

    public int getMaterialId() {
        return MaterialId;
    }

    public void setMaterialId(int materialId) {
        MaterialId = materialId;
    }

    public String getCafeName() {
        return CafeName;
    }

    public void setCafeName(String cafeName) {
        CafeName = cafeName;
    }

    public int getQuantityAvailable() {
        return QuantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        QuantityAvailable = quantityAvailable;
    }

    public int getUnitMeasurement() {
        return UnitMeasurement;
    }

    public void setUnitMeasurement(int unitMeasurement) {
        UnitMeasurement = unitMeasurement;
    }
}
