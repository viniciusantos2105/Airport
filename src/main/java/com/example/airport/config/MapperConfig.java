package com.example.airport.config;

import com.example.airport.dto.flight.FlightClassViewDTO;
import com.example.airport.models.FlightClass;
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
        return mapper;
    }
}
