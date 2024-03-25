package com.example.airport.dto.flight;

import com.example.airport.dto.airport.AirportViewDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightViewListDTO {

    private Long flightNumber;
    private AirportViewDTO originAirport;
    private AirportViewDTO destinationAirport;
    private Date departureDateTime;
}
