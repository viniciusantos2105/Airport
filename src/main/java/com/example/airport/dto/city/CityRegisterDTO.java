package com.example.airport.dto.city;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityRegisterDTO {

    @NotBlank(message = "Nome da cidade, não pode ser vazio")
    private String nameCity;
    @NotBlank(message = "Unidade federativa não pode ser vazia")
    private String federativUnit;
}
