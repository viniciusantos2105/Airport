package com.example.airport.service;

import com.example.airport.dto.city.CityRegisterDTO;
import com.example.airport.models.City;
import com.example.airport.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City save(CityRegisterDTO cityRegisterDto){
        City city = new City(cityRegisterDto.getNameCity(), cityRegisterDto.getFederativUnit());
        return cityRepository.save(city);
    }

    public City findById(Long id){
        return cityRepository.findById(id).orElseThrow();
    }
}
