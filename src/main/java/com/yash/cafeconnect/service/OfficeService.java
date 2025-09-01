package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Office;

import java.util.List;

public interface OfficeService {

    //Add new Office
    void addOffice(Office office);

    //Get Office By Id
    Office getOfficeById(int officeId);

    //Update Office details
    void updateOfficeById(Office office);

    //Remove Office By Id
    void deleteOfficeById(int officeId);

    List<Office> getOffices();
}
