package com.example.airport.service;

import com.example.airport.adapter.FlightAdapter;
import com.example.airport.dto.flight.FlightClassDTO;
import com.example.airport.dto.flight.FlightRegisterDTO;
import com.example.airport.dto.flight.FlightViewDTO;
import com.example.airport.enums.FlightClassEnum;
import com.example.airport.models.Airport;
import com.example.airport.models.Flight;
import com.example.airport.models.FlightClass;
import com.example.airport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    private final AirportService airportService;
    @Autowired
    private  FlightAdapter flightAdapter;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public FlightService(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public FlightViewDTO save(FlightRegisterDTO flightRegisterDTO) throws ParseException {
        Airport destinationAirport = airportService.findById(flightRegisterDTO.getDestinationAirportId());
        Airport originAirport = airportService.findById(flightRegisterDTO.getOriginAirportId());
        Date flightDateTime = dateFormat.parse(flightRegisterDTO.getDepartureDateTime());
        validateFlight(destinationAirport, originAirport, flightDateTime);

        Flight flight = new Flight(originAirport, destinationAirport, flightDateTime);

        for(FlightClassDTO flightClassDTO : flightRegisterDTO.getFlightClassDTOS()){
            FlightClass flightClass = parseFlightClass(flightClassDTO);
            flight.getFlightClasses().add(flightClass);
        }
        flightRepository.save(flight);
        return flightAdapter.adapterRegisterFlight(flight);
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

    public void validateFlight(Airport destinationAirport, Airport originAirport, Date flightDateTime){
        //TODO: TRATAR EXCEPTIONS
        if(destinationAirport.getCityAirport().equals(originAirport.getCityAirport())) throw new RuntimeException("Não podem exisistir voos para a mesma cidade");
        LocalDateTime flightLocalDateTime = flightDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        if(flightLocalDateTime.isBefore(LocalDateTime.now())) throw new RuntimeException("Não podem criar voos em horarios passados");
    }
}
