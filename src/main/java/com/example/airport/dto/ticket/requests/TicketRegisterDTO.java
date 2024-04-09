package com.example.airport.dto.ticket.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketRegisterDTO {

    private Long idVisitor;
    private Long idFlight;
    private String classSelected;
}
