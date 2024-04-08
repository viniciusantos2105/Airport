package com.example.airport.dto.flight;

import com.example.airport.dto.airport.responses.AirportViewDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightViewDTO {

    private Long flightNumber;
    private AirportViewDTO originAirport;
    private AirportViewDTO destinationAirport;
    private Date departureDateTime;
    private List<FlightClassViewDTO> flightClassViewDTO = new ArrayList<>();
}
