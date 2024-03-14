package com.example.airport.dto.airport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportRegisterDTO {

    @NotBlank(message = "Não pode ser vazio")
    private String nameAirport;
    @NotNull(message = "Não pode ser vazio")
    private Long idCity;
}
