package com.example.airport.adapter;

import com.example.airport.config.MapperConfig;
import com.example.airport.dto.airport.AirportViewDTO;
import com.example.airport.models.Airport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AirportAdapter {

    public final ModelMapper mapper = new MapperConfig().modelMapper();

    public AirportViewDTO adapterViewAirport(Airport airport){
        AirportViewDTO airportViewDTO = mapper.map(airport, AirportViewDTO.class);
        return airportViewDTO;
    }
}
