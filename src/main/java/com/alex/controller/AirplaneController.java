package com.alex.controller;

import com.alex.model.Airplane;
import com.alex.service.AirplaneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airplane")
public class AirplaneController {

    private final AirplaneService as;

    public AirplaneController(AirplaneService airplaneService) {
        this.as = airplaneService;
    }

    @PostMapping("/save/{airCompanyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAirplaneWithAirCompany(@RequestBody Airplane airplane, @PathVariable long airCompanyId) {
        as.save(airplane, airCompanyId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAirplane(@RequestBody Airplane airplane) {
        as.save(airplane);
    }

    @PutMapping("/move/{airplaneId}/{airCompanyId}")
    @ResponseStatus(HttpStatus.OK)
    public void moveAirplane(@PathVariable long airplaneId, @PathVariable long airCompanyId) {
        as.move(airplaneId, airCompanyId);
    }

}
