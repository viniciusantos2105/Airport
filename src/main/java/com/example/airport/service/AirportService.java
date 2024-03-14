package com.example.airport.service;

import com.example.airport.adapter.AirportAdapter;
import com.example.airport.dto.airport.AirportRegisterDTO;
import com.example.airport.dto.airport.AirportViewDTO;
import com.example.airport.models.Airport;
import com.example.airport.models.City;
import com.example.airport.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    private final CityService cityService;

    @Autowired
    private AirportAdapter airportAdapter;

    public AirportService(AirportRepository airportRepository, CityService cityService) {
        this.airportRepository = airportRepository;
        this.cityService = cityService;
    }

    public List<AirportViewDTO> listAllAirports(){
        List<Airport> airportList = airportRepository.findAll();
        List<AirportViewDTO> airportViewDTOList = new ArrayList<>();
        for(Airport airport : airportList){
            AirportViewDTO airportViewDTO = airportAdapter.adapterViewAirport(airport);
            airportViewDTOList.add(airportViewDTO);
        }
        return airportViewDTOList;
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
