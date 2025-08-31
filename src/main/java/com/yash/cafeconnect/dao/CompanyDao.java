package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Company;
import java.util.List;

/**
 * The CompanyDao interface for performing operations on company entity.
 */
public interface CompanyDao {

    //Saves new Company
    void saveCompany(Company company);

    /**
     * Retrieves company based on companId.
     * @param companyId (Unique Id of company)
     * @return Company object if found, otherwise null.
     */
    Company getCompany(int companyId);

    //Updates an existing Company object
    void UpdateCompany(Company company);

    //Deletes company by its companyId
    void DeleteCompany(int cafeId);

    List<Company> getCompanies();

}
