package com.microservices.microservices.Controller.Company;


import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean delete(Long id);
    Company getCompanyById(Long id);
}
