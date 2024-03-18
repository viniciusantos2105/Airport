package com.example.airport.dto.ticket;

import com.example.airport.dto.visitor.VisitorViewTicketDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketViewDTO {

    private Long ticketNumber;
    private Double price;
    private String flightClass;
    private VisitorViewTicketDTO visitorViewTicketDTO = new VisitorViewTicketDTO();
}
