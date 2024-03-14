package com.example.airport.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FlightClassEnum {

    ECONOMICA("Economica"),
    EXECUTIVA("Executiva"),
    CLASSE_A("Classe A");

    private final String description;

    public String getDescription() {
        return description;
    }
}
