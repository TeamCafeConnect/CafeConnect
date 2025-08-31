package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Cafe;
import java.util.List;

public interface CafeService {

    //Add a new Cafe
    void addCafe(Cafe cafe);

    //Get cafe by Id
    Cafe getCafeById(int cafeId);

    //Update cafe details
    void updateCafeById(Cafe cafe);

    //Remove Cafe by Id
    void removeCafeById(int cafeId);

    //Get list of all cafes
    List<Cafe> getCafes();
}
