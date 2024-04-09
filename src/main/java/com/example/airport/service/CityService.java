package com.example.airport.service;

import com.example.airport.adapter.Adapter;
import com.example.airport.dto.city.requests.CityRegisterDTO;
import com.example.airport.dto.city.responses.CityRegisterResponseDTO;
import com.example.airport.models.City;
import com.example.airport.repository.city.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityRegisterResponseDTO createCity(CityRegisterDTO cityRegisterDto){
        City city = new City(cityRegisterDto.getNameCity(), cityRegisterDto.getFederativUnit());
        cityRepository.save(city);
        return Adapter.mapSourceToTarget(city, CityRegisterResponseDTO.class);
    }

    public City findById(Long id){
        return cityRepository.findById(id).orElseThrow();
    }
}
