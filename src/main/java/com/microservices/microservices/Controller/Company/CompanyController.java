package com.microservices.microservices.Controller.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                                @RequestBody Company company){
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Company updated successfully",
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully",
                HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        boolean isdeleted=companyService.delete(id);
        if(isdeleted){
        return new ResponseEntity<>("Company deleted successfully",
                HttpStatus.OK);}
        return new ResponseEntity<>("Company not deleted successfully",
                HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company comapany =companyService.getCompanyById(id);
        if(comapany!=null){
            return new ResponseEntity<>(comapany, HttpStatus.OK);}
        return new ResponseEntity<>(null,
                HttpStatus.NOT_FOUND);
    }
}
