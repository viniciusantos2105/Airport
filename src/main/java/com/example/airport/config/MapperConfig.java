package com.example.airport.config;

import com.example.airport.dto.airport.responses.AirportViewDTO;
import com.example.airport.models.Airport;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
//        mapper.createTypeMap(FlightClass.class, FlightClassViewDTO.class)
//                .addMappings(m -> m.map(src -> src.getClassEnum().getDescription(), FlightClassViewDTO::setClassEnum))
//                .addMappings(m -> m.map(FlightClass::getSeats, FlightClassViewDTO::setSeats));
        mapper.createTypeMap(Airport.class, AirportViewDTO.class)
                .addMappings(m -> m.map(src -> src.getCityAirport().getNameCity(), AirportViewDTO::setCityAirport))
                .addMappings(m -> m.map(Airport::getNameAirport, AirportViewDTO::setNameAirport));
        return mapper;
    }
}
