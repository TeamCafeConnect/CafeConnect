package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Company;
import java.util.List;


public interface CompanyService {

    void addCompany(Company company);

    Company getCompanyById(int companyId);

    void UpdateCompany(Company company);

    void removeCompanyById(int companyId);

    List <Company> getCompanies();
}