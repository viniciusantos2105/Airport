package com.example.airport.controller;

import com.example.airport.dto.city.CityRegisterDTO;
import com.example.airport.models.City;
import com.example.airport.service.CityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
public class CityController {


    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody @Valid CityRegisterDTO cityRegisterDTO){
        City city = cityService.createCity(cityRegisterDTO);
        return ResponseEntity.ok().body(city);
    }
}
