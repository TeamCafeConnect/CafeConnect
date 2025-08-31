package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Cafe;

import java.util.List;

/**
 * The CafeDao interface defines the standard operations to be performed on cafe entity.
 */

public interface CafeDao {


    //Saves a new Cafe
    void saveCafe(Cafe cafe);

    /**
     * Retrieves Cafe based in cafeId.
     * @param cafeId
     * @return Cafe object
     */
    Cafe getCafe(int cafeId);

    //Update cafe(matched by Id)
    void updateCafe(Cafe cafe);

    //Delete cafe by Id
    void deleteCafe(int cafeId);

    List<Cafe> getCafes();

}
