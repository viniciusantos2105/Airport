package com.example.airport.dto.flight;

import com.example.airport.enums.FlightClassEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightClassViewDTO {

    private String classEnum;
    private Integer seats;

}
