package com.example.airport.service;

import com.example.airport.adapter.FlightAdapter;
import com.example.airport.dto.flight.FlightClassRegisterDTO;
import com.example.airport.dto.flight.FlightRegisterDTO;
import com.example.airport.dto.flight.FlightViewDTO;
import com.example.airport.dto.flight.FlightViewListDTO;
import com.example.airport.enums.FlightClassEnum;
import com.example.airport.models.Airport;
import com.example.airport.models.Flight;
import com.example.airport.models.FlightClass;
import com.example.airport.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository repository;
    private final AirportService airportService;
    private final FlightAdapter flightAdapter;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public FlightService(FlightRepository flightRepository, AirportService airportService, FlightAdapter flightAdapter) {
        this.repository = flightRepository;
        this.airportService = airportService;
        this.flightAdapter = flightAdapter;
    }

    public List<FlightViewListDTO> listFlight(){
        List<Flight> flightList = repository.findAll();
        List<FlightViewListDTO> viewFlightList = new ArrayList<>();
        for(Flight flight : flightList){
            FlightViewListDTO flightView = flightAdapter.adapterViewListFlight(flight);
            viewFlightList.add(flightView);
        }
        return viewFlightList;
    }


    public FlightViewDTO createFlight(FlightRegisterDTO flightRegisterDTO) throws ParseException {
        Airport destinationAirport = airportService.findById(flightRegisterDTO.getDestinationAirportId());
        Airport originAirport = airportService.findById(flightRegisterDTO.getOriginAirportId());
        Date flightDateTime = dateFormat.parse(flightRegisterDTO.getDepartureDateTime());
        validateFlight(destinationAirport, originAirport, flightDateTime);

        Flight flight = new Flight(originAirport, destinationAirport, flightDateTime);

        for(FlightClassRegisterDTO flightClassDTO : flightRegisterDTO.getFlightClassDTOS()){
            FlightClass flightClass = parseFlightClass(flightClassDTO);
            flight.getFlightClasses().add(flightClass);
        }
        repository.save(flight);
        return flightAdapter.adapterRegisterFlight(flight);
    }

    private FlightClass parseFlightClass(FlightClassRegisterDTO flightClassDTO){
        for(FlightClassEnum flightClassEnum : FlightClassEnum.values()){
            if(flightClassEnum.getDescription().equalsIgnoreCase(flightClassDTO.getClassEnum())){
               return new FlightClass(flightClassEnum, flightClassDTO.getSeats(), flightClassDTO.getValueClass());
            }
        }
        //TODO: TRATAR ESSE RETORNO
        return null;
    }

    private void validateFlight(Airport destinationAirport, Airport originAirport, Date flightDateTime){
        //TODO: TRATAR EXCEPTIONS
        if(destinationAirport.getCityAirport().equals(originAirport.getCityAirport())) throw new RuntimeException("Não podem exisistir voos para a mesma cidade");
        LocalDateTime flightLocalDateTime = flightDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        if(flightLocalDateTime.isBefore(LocalDateTime.now())) throw new RuntimeException("Não podem criar voos em horarios passados");
    }

    public Flight findFlightById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Voo não encontrado!"));
    }

    public void updateSeatsFlightClass(Flight flight, String classSelected){
        for(FlightClass flightClass : flight.getFlightClasses()){
            if(flightClass.getClassEnum().getDescription().equalsIgnoreCase(classSelected) && flightClass.getSeats() > 0){
                flightClass.setSeats(flightClass.getSeats() -1);
            }
        }
        repository.save(flight);
    }
}
