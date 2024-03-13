package com.example.airport.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlightClassEnum {

    ECONOMICA("Economica"),
    EXECUTIVA("Executiva"),
    CLASSE_A("Classe A");

    private final String description;
}
