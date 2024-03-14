package com.example.airport.adapter;

import com.example.airport.config.MapperConfig;
import com.example.airport.dto.flight.FlightClassViewDTO;
import com.example.airport.dto.flight.FlightViewDTO;
import com.example.airport.models.Flight;
import com.example.airport.models.FlightClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightAdapter {

    public final ModelMapper mapper = new MapperConfig().modelMapper();


    public FlightViewDTO adapterRegisterFlight(Flight flight){
        FlightViewDTO flightViewDTO =  mapper.map(flight, FlightViewDTO.class);
        for(FlightClass flightClass : flight.getFlightClasses()){
            FlightClassViewDTO classViewDTO = new FlightClassViewDTO(flightClass.getClassEnum().getDescription(), flightClass.getSeats());
            flightViewDTO.getFlightClassViewDTO().add(classViewDTO);
        }
        return flightViewDTO;
    }
}
