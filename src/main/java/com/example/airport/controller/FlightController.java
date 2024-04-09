package com.example.airport.controller;

import com.example.airport.dto.flight.requests.FlightRegisterDTO;
import com.example.airport.dto.flight.responses.FlightViewDTO;
import com.example.airport.dto.flight.responses.FlightViewListDTO;
import com.example.airport.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Método de criação de voo")
    @PostMapping("/create")
    public ResponseEntity<FlightViewDTO> create(@RequestBody @Valid FlightRegisterDTO flightRegisterDTO) throws ParseException {
       FlightViewDTO flight = flightService.createFlight(flightRegisterDTO);
       return ResponseEntity.ok().body(flight);
    }

    @Operation(summary = "Método de criação de voos")
    @GetMapping("/list")
    public ResponseEntity<List<FlightViewListDTO>> listFlight(){
        List<FlightViewListDTO> flightList = flightService.listFlight();
        return ResponseEntity.ok().body(flightList);
    }
}
