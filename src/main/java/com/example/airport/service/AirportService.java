package com.example.airport.service;

import com.example.airport.dto.airport.AirportRegisterDTO;
import com.example.airport.models.Airport;
import com.example.airport.models.City;
import com.example.airport.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    private final CityService cityService;

    public AirportService(AirportRepository airportRepository, CityService cityService) {
        this.airportRepository = airportRepository;
        this.cityService = cityService;
    }

    public Airport save(AirportRegisterDTO airportRegisterDTO){
        City city = cityService.findById(airportRegisterDTO.getIdCity());
        Airport airport = new Airport(airportRegisterDTO.getNameAirport(), city);
        return airportRepository.save(airport);
    }

    public Airport findById(Long id){
        return airportRepository.findById(id).orElseThrow();
    }
}
