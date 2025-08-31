package com.yash.cafeconnect.entity;

public class Office {

    private int officeId;
    private String officeName;
    private String companyName;
    private String city;

    public Office(){}

    public Office(int officeId, String officeName, String companyName, String city){
        this.officeId = officeId;
        this.officeName = officeName;
        this.companyName = companyName;
        this.city = city;
    }

    public int getOfficeId(){
        return officeId;
    }

    public void setOfficeId(int officeId){
        this.officeId = officeId;
    }

    public String getOfficeName(){
        return officeName;
    }

    public void setOfficeName(String officeName){
        this.officeName = officeName;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

}
