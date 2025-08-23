package com.yash.cafeconnect.entity;
import com.yash.cafeconnect.entity.enums.CafeStatus;

public class Cafe {

    private int cafeId;
    private String cafeName;
    private CafeStatus cafeStatus;
    private Company company;

    public Cafe(int cafeId, String cafeName, CafeStatus cafeStatus, Company company){
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.cafeStatus = cafeStatus;
        this.company = company;
    }

    public Cafe(){}

    public int getCafeId(){
        return cafeId;
    }

    public void setCafeId(int cafeId){
        this.cafeId = cafeId;
    }

    public String getCafeName(){
        return cafeName;
    }

    public void setCafeName(String cafeName){
        this.cafeName = cafeName;
    }

    public CafeStatus getCafestatus(){
        return cafeStatus ;
    }

    public void setCafeStatus(CafeStatus cafeStatus){
        this.cafeStatus = cafeStatus;
    }

}
//private List<Menu> menuList;
