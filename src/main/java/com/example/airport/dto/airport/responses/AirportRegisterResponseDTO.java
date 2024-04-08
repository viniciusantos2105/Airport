package com.example.airport.dto.airport.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportRegisterResponseDTO {

    private Long codeIATA;
    private String nameAirport;
    private String nameCity;
}
