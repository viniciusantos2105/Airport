package com.example.airport.service;

import com.example.airport.dto.flight.FlightClassDTO;
import com.example.airport.dto.flight.FlightRegisterDTO;
import com.example.airport.enums.FlightClassEnum;
import com.example.airport.models.Airport;
import com.example.airport.models.Flight;
import com.example.airport.models.FlightClass;
import com.example.airport.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    private final AirportService airportService;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public FlightService(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public Flight save(FlightRegisterDTO flightRegisterDTO) throws ParseException {
        Airport destinationAirport = null;
//                airportService.findById(flightRegisterDTO.getDestinationAirportId());
        Airport originAirport = null;
//                airportService.findById(flightRegisterDTO.getOriginAirportId());
        Date flightDateTime = dateFormat.parse(flightRegisterDTO.getDepartureDateTime());

        Flight flight = new Flight(originAirport, destinationAirport, flightDateTime);

        for(FlightClassDTO flightClassDTO : flightRegisterDTO.getFlightClassDTOS()){
            FlightClass flightClass = parseFlightClass(flightClassDTO);
            flight.getFlightClasses().add(flightClass);
        }
        return flight;
    }

    public FlightClass parseFlightClass(FlightClassDTO flightClassDTO){
        for(FlightClassEnum flightClassEnum : FlightClassEnum.values()){
            if(flightClassEnum.getDescription().equalsIgnoreCase(flightClassDTO.getClassEnum())){
               return new FlightClass(flightClassEnum, flightClassDTO.getSeats());
            }
        }
        //TODO: TRATAR ESSE RETORNO
        return null;
    }


}
