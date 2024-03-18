package com.example.airport.controller;

import com.example.airport.dto.airport.AirportRegisterDTO;
import com.example.airport.dto.airport.AirportViewDTO;
import com.example.airport.models.Airport;
import com.example.airport.service.AirportService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
public class AirportController {


    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/create")
    public ResponseEntity<Airport> create(@RequestBody @Valid AirportRegisterDTO airportRegisterDTO){
        Airport airport = airportService.createAirport(airportRegisterDTO);
        return ResponseEntity.ok().body(airport);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AirportViewDTO>> listAllAirports(){
        List<AirportViewDTO> airportViewDTO = airportService.listAllAirports();
        return ResponseEntity.ok().body(airportViewDTO);
    }
}
