package com.yash.cafeconnect.entity;

public class Company {
    private int companyId;
    private String companyName;
    private String ownerName;

    public Company(int companyId, String companyName, String ownerName){
        this.companyId = companyId;
        this.companyName = companyName;
        this.ownerName = ownerName;
    }

    public Company(){}

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
            this.companyName = companyName;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

}
