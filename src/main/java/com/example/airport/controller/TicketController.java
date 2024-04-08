package com.example.airport.controller;

import com.example.airport.dto.ticket.TicketRegisterDTO;
import com.example.airport.dto.ticket.TicketViewDTO;
import com.example.airport.dto.visitor.VisitorRegisterDTO;
import com.example.airport.dto.visitor.VisitorViewDTO;
import com.example.airport.models.Ticket;
import com.example.airport.repository.TicketRepository;
import com.example.airport.service.TicketService;
import com.example.airport.service.VisitorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Operation(summary = "Método de compra de passagem")
    @PostMapping("/create")
    public ResponseEntity<TicketViewDTO> create(@RequestBody @Valid TicketRegisterDTO ticketRegisterDTO) throws ParseException {
        TicketViewDTO ticket = ticketService.buyTicket(ticketRegisterDTO);
        return ResponseEntity.ok().body(ticket);
    }
}
