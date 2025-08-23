package com.yash.cafeconnect.entity;

import java.util.List;

public class Office {

    private int officeId;
    private String officeName;
    private String city;

    public Office(){}

    public Office(int officeId, String officeName, String city){
        this.officeId = officeId;
        this.officeName = officeName;
        this.city = city;
    }

    public int getOfficeId(){
        return officeId;
    }

    public void setOfficeId(int officeName){
        this.officeId = officeId;
    }

    public String getOfficeName(){
        return officeName;
    }

    public void setOfficeName(String officeName){
        this.officeName = officeName;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String City){
        this.city = city;
    }

}
