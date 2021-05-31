package com.alex.service;

import com.alex.model.AirCompany;
import com.alex.model.Airplane;
import com.alex.model.Flight;
import com.alex.model.Flight.FlightStatus;
import com.alex.repository.FlightRepo;
import com.alex.service.exceptions.FlightNoFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @PersistenceContext
    private EntityManager em;

    private final FlightRepo flightRepo;

    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public void save(Flight flight, long airCompanyId, long airPlaneId) {
        flight.setFlightStatus(FlightStatus.PENDING);
        AirCompany proxyAirCompany = em.getReference(AirCompany.class, airCompanyId);
        Airplane proxyAirplane = em.getReference(Airplane.class, airPlaneId);
        flight.setAirCompany(proxyAirCompany);
        flight.setAirplane(proxyAirplane);
        flightRepo.save(flight);
    }

    @Transactional
    public void changeStatus(long flightId, FlightStatus newStatus) {
        Flight flight = flightRepo.findById(flightId).orElseThrow(FlightNoFoundException::new);
        switch (newStatus) {
            case DELAYED:
                flight.setFlightStatus(newStatus);
                flight.setDelayStarted(LocalDateTime.now());
                break;
            case ACTIVE:
                flight.setFlightStatus(newStatus);
                flight.setStarted(LocalDateTime.now());
                break;
            case COMPLETED:
                flight.setFlightStatus(newStatus);
                flight.setEnded(LocalDateTime.now());
        }
    }


    public List<Flight> activeFlights() {
        List<Flight> activeStatus = flightRepo.findAllByFlightStatus(FlightStatus.ACTIVE);
        return activeStatus.stream()
                .filter(flight -> LocalDateTime.now().isAfter(flight.getStarted().plusHours(24)))
                .collect(Collectors.toList());
    }

    public List<Flight> flightsByCompanyNameAndStatus(String companyName, String status) {
        return flightRepo.findAllByAirCompany_NameAndFlightStatus(companyName,FlightStatus.valueOf(status));
    }

    public List<Flight> completedFlights() {
        List<Flight> completed = flightRepo.findAllByFlightStatus(FlightStatus.COMPLETED);
        List<Flight> result=completed.stream().filter(FlightService::timeFilter).collect(Collectors.toList());
        return result;
    }

    private static boolean timeFilter(Flight flight){
        LocalDateTime started = flight.getStarted();
        LocalDateTime completed = flight.getEnded();
        LocalTime estimatedFlightTime = flight.getEstimatedFlightTime();
        LocalTime localTime=completed.minusYears(started.getYear()).minusMonths(started.getMonthValue()).minusDays(started.getDayOfMonth()).minusHours(started.getHour()).minusMinutes(started.getMinute()).toLocalTime();
        return estimatedFlightTime.compareTo(localTime)<0;
    }
}
