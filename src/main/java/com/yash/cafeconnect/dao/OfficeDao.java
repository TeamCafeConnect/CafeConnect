package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Office;

/**
 * The OfficeDao interface defines standard operations to be performed on Office entity.
 */

public interface OfficeDao {

    // saves new office
    void saveOffice(Office office);

    /**
     * Retrieves office by officeId
     * @param OfficeId
     * @return Office object
     */
    Office getOffice(int OfficeId);

    //Update cafe(matched by Id)
    void UpdateOffice(Office office);

    /**
     * Deletes office by officeId
     * @param OfficeId
     */
    void deleteOffice(int OfficeId);


}
