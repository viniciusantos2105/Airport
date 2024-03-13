package com.example.airport.dto.flight;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightRegisterDTO {
    @NotNull(message = "Não pode ser vazio")
    private Long originAirportId;
    @NotNull(message = "Nao pode ser vazio")
    private Long destinationAirportId;
    @NotBlank(message = "Não pode ser vazio")
    private String departureDateTime;
    @NotBlank(message = "Não pode ser nulo")
    private List<FlightClassDTO> flightClassDTOS;
}
