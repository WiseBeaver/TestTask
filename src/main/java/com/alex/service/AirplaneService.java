package com.alex.service;

import com.alex.model.AirCompany;
import com.alex.model.Airplane;
import com.alex.repository.AirplaneRepo;
import com.alex.service.exceptions.AirplaneNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class AirplaneService {

    @PersistenceContext
    private EntityManager em;

    private final AirplaneRepo airplaneRepo;

    public AirplaneService(AirplaneRepo airplaneRepo) {
        this.airplaneRepo = airplaneRepo;
    }

    public void save(Airplane airplane) {
        airplaneRepo.save(airplane);
    }

    @Transactional
    public void save(Airplane airplane, long airCompanyId) {
        AirCompany proxyAirCompany = em.getReference(AirCompany.class, airCompanyId);
        airplane.setAirCompany(proxyAirCompany);
        airplaneRepo.save(airplane);
    }

    @Transactional
    public void move(long airplaneId, long airCompanyId) {
        Airplane airplane = airplaneRepo.findById(airplaneId).orElseThrow(AirplaneNotFoundException::new);
        AirCompany proxyAirCompany = em.getReference(AirCompany.class, airCompanyId);
        airplane.setAirCompany(proxyAirCompany);
    }


}
