package com.example.airport.controller;

import com.example.airport.dto.airport.requests.AirportRegisterDTO;
import com.example.airport.dto.airport.responses.AirportRegisterResponseDTO;
import com.example.airport.dto.airport.responses.AirportViewDTO;
import com.example.airport.service.AirportService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Método de criação de aeroporto")
    @PostMapping("/create")
    public ResponseEntity<AirportRegisterResponseDTO> create(@RequestBody @Valid AirportRegisterDTO airportRegisterDTO){
        AirportRegisterResponseDTO airport = airportService.createAirport(airportRegisterDTO);
        return ResponseEntity.ok().body(airport);
    }

    @Operation(summary = "Método de listagem de aeroportos")
    @GetMapping("/list")
    public ResponseEntity<List<AirportViewDTO>> listAllAirports(){
        List<AirportViewDTO> airportViewDTO = airportService.listAllAirports();
        return ResponseEntity.ok().body(airportViewDTO);
    }
}
