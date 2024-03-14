package com.example.airport.dto.flight;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotNull(message = "Local de origem não pode ser vazio")
    private Long originAirportId;
    @NotNull(message = "Local de destino não pode ser vazio")
    private Long destinationAirportId;
    @NotBlank(message = "Horario não pode ser vazio")
    private String departureDateTime;
    @NotEmpty(message = "Os voos devem possuir pelo menos uma classe")
    private List<FlightClassRegisterDTO> flightClassDTOS;
}
