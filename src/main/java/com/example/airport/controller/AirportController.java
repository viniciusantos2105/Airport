package com.example.airport.controller;

import com.example.airport.dto.airport.AirportRegisterDTO;
import com.example.airport.models.Airport;
import com.example.airport.service.AirportService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airport")
public class AirportController {


    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/create")
    public ResponseEntity<Airport> create(@RequestBody @Valid AirportRegisterDTO airportRegisterDTO){
        Airport airport = airportService.save(airportRegisterDTO);
        return ResponseEntity.ok().body(airport);
    }
}
