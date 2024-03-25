package com.example.airport.controller;

import com.example.airport.dto.flight.FlightRegisterDTO;
import com.example.airport.dto.flight.FlightViewDTO;
import com.example.airport.dto.flight.FlightViewListDTO;
import com.example.airport.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/create")
    public ResponseEntity<FlightViewDTO> create(@RequestBody @Valid FlightRegisterDTO flightRegisterDTO) throws ParseException {
       FlightViewDTO flight = flightService.createFlight(flightRegisterDTO);
       return ResponseEntity.ok().body(flight);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FlightViewListDTO>> listFlight(){
        List<FlightViewListDTO> flightList = flightService.listFlight();
        return ResponseEntity.ok().body(flightList);
    }
}
