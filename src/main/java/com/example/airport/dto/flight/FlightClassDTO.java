package com.example.airport.dto.flight;

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
public class FlightClassDTO {

    @NotBlank(message = "A classe do voo não pode ser vazia")
    private String classEnum;
    @NotNull(message = "")
    private Integer seats;
}
