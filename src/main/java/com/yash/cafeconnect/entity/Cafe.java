package com.yash.cafeconnect.entity;
import com.yash.cafeconnect.entity.enums.CafeStatus;

public class Cafe {

    private int cafeId;
    private String cafeName;
    private CafeStatus cafeStatus;
    private int companyId;

    public Cafe(int cafeId, String cafeName, CafeStatus cafeStatus, int companyId){
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.cafeStatus = cafeStatus;
        this.companyId = companyId;
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

    public int getCompanyId(){
        return companyId;
    }

    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }

}
