package com.alex.controller;


import com.alex.model.Flight;
import com.alex.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService fs;

    public FlightController(FlightService flightService) {
        this.fs = flightService;
    }

    @PostMapping("/save/{airCompanyId}/{airPlaneId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFlight(@RequestBody Flight flight,@PathVariable long airCompanyId,@PathVariable long airPlaneId){
        fs.save(flight,airCompanyId,airPlaneId);
    }


    @PutMapping("/status/{flightId}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public void changeStatus(@PathVariable long flightId,@PathVariable String status){
        fs.changeStatus(flightId, Flight.FlightStatus.valueOf(status));
    }

    @GetMapping("/flights")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> flights(){
        return fs.activeFlights();
    }


    @GetMapping("/flightsbystatus/{companyName}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> flightsByStatus(@PathVariable String companyName,@PathVariable String status){
        return fs.flightsByCompanyNameAndStatus(companyName,status);
    }

    @GetMapping("/completedflights")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> completedFlights(){
        return fs.completedFlights();
    }

}
