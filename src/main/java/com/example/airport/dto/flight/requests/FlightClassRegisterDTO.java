package com.example.airport.dto.flight.requests;

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
public class FlightClassRegisterDTO {

    @NotBlank(message = "A classe do voo não pode ser vazia")
    private String classEnum;
    @NotNull(message = "Numero de assentos não pode ser vazio")
    private Integer seats;
    @NotNull(message = "Valor da classe não pode ser vazio")
    private Double valueClass;
}
