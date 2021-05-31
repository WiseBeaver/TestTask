package com.alex.repository;


import com.alex.model.Flight;
import com.alex.model.Flight.FlightStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FlightRepo extends CrudRepository<Flight,Long> {
        List<Flight> findAllByFlightStatus(FlightStatus flightStatus);
        List<Flight> findAllByAirCompany_NameAndFlightStatus(String airCompanyName,FlightStatus flightStatus);
}
