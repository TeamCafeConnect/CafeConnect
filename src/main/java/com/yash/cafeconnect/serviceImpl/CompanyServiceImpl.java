package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.Company;
import com.yash.cafeconnect.dao.CompanyDao;
import com.yash.cafeconnect.daoImpl.CompanyDaoImpl;
import com.yash.cafeconnect.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private CompanyDao companyDao = new CompanyDaoImpl();

    public void addCompany(Company company) {
        if (company.getCompanyName() == null || company.getCompanyName().isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        if (companyDao.getCompany(company.getCompanyId()) != null) {
            throw new IllegalStateException("Company with this ID already exists");
        }
        companyDao.saveCompany(company);
    }

    public Company getCompanyById(int companyId) {
        return companyDao.getCompany(companyId);
    }

    public void UpdateCompany(Company company) {
        if(companyDao.getCompany(company.getCompanyId()) == null){
            throw new IllegalStateException("Company with this ID already exists");
        }
        companyDao.UpdateCompany(company);
    }

    public void removeCompanyById(int companyId) {
        if(companyDao.getCompany(companyId) == null){
            throw new IllegalStateException("Company with this ID already exists");
        }
        companyDao.DeleteCompany(companyId);
    }

    public List<Company> getCompanies() {
        return companyDao.getCompanies();
    }
}
