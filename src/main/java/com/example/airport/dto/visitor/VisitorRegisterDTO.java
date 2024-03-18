package com.example.airport.dto.visitor;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitorRegisterDTO {
    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @NotBlank(message = "Email não pode ser vazio")
    private String email;
    @NotBlank(message = "Senha não pode ser vazia")
    private String password;
    @NotNull(message = "Cpf não pode ser vazio")
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank(message = "Horario não pode ser vazio")
    private String birthDate;

}
