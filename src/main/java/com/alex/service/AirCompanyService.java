package com.alex.service;

import com.alex.model.AirCompany;
import com.alex.repository.AirCompanyRepo;
import com.alex.service.exceptions.CompanyNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyService {

    private final AirCompanyRepo acr;

    public AirCompanyService(AirCompanyRepo airCompanyRepo) {
        this.acr = airCompanyRepo;
    }

    public Iterable<AirCompany> findAll(){
        return acr.findAll();
    }

    public AirCompany findById(long id) {
        return acr.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    public void save(AirCompany airCompany) {
        acr.save(airCompany);
    }

    public void deleteById(long id) {
        acr.deleteById(id);
    }

    public void update(long id, AirCompany airCompany) {
        airCompany.setId(id);
        acr.save(airCompany);
    }
}
