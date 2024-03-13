package com.example.airport.controller;

import com.example.airport.dto.flight.FlightRegisterDTO;
import com.example.airport.models.Flight;
import com.example.airport.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/create")
    public ResponseEntity<Flight> create(@RequestBody @Valid FlightRegisterDTO flightRegisterDTO) throws ParseException {
       Flight flight = flightService.save(flightRegisterDTO);
       return ResponseEntity.ok().body(flight);
    }
}
