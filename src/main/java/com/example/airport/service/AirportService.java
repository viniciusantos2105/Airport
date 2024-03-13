package com.example.airport.service;

import com.example.airport.models.Airport;
import com.example.airport.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport findById(Long id){
        return airportRepository.findById(id).orElseThrow();
    }
}
