package com.example.airport.config;

import com.example.airport.dto.airport.AirportViewDTO;
import com.example.airport.dto.flight.FlightClassViewDTO;
import com.example.airport.dto.ticket.TicketViewDTO;
import com.example.airport.dto.visitor.VisitorViewTicketDTO;
import com.example.airport.models.Airport;
import com.example.airport.models.FlightClass;
import com.example.airport.models.Ticket;
import com.example.airport.models.users.Person;
import com.example.airport.models.users.Visitor;
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
