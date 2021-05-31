package com.alex.controller;

import com.alex.model.AirCompany;
import com.alex.service.AirCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aircompany")
public class AirCompanyController {

    private final AirCompanyService acs;

    public AirCompanyController(AirCompanyService airCompanyService) {
        this.acs = airCompanyService;
    }

    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<AirCompany> getAllCompanies(){
        return acs.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AirCompany getCompanyById(@PathVariable long id){
        return acs.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCompany(@RequestBody AirCompany airCompany){
        acs.save(airCompany);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCompanyById(@PathVariable long id){
        acs.deleteById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompany(@RequestBody AirCompany airCompany,@PathVariable long id){
        acs.update(id,airCompany);
    }

}
