package com.example.airport.service;

import com.example.airport.adapter.Adapter;
import com.example.airport.dto.airport.requests.AirportRegisterDTO;
import com.example.airport.dto.airport.responses.AirportRegisterResponseDTO;
import com.example.airport.dto.airport.responses.AirportViewDTO;
import com.example.airport.models.Airport;
import com.example.airport.models.City;
import com.example.airport.repository.airport.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    private final CityService cityService;

    public AirportService(AirportRepository airportRepository, CityService cityService) {
        this.airportRepository = airportRepository;
        this.cityService = cityService;
    }

    public List<AirportViewDTO> listAllAirports(){
        List<Airport> airportList = airportRepository.findAll();
        List<AirportViewDTO> airportViewDTOList = new ArrayList<>();
        for(Airport airport : airportList){
            AirportViewDTO airportViewDTO = Adapter.mapSourceToTarget(airport, AirportViewDTO.class);
            airportViewDTOList.add(airportViewDTO);
        }
        return airportViewDTOList;
    }

    public AirportRegisterResponseDTO createAirport(AirportRegisterDTO airportRegisterDTO){
        City city = cityService.findById(airportRegisterDTO.getIdCity());
        Airport airport = new Airport(airportRegisterDTO.getNameAirport(), city);
        airportRepository.save(airport);
        return Adapter.mapSourceToTarget(airport, AirportRegisterResponseDTO.class);
    }

    public Airport findById(Long id){
        return airportRepository.findById(id).orElseThrow();
    }


}
