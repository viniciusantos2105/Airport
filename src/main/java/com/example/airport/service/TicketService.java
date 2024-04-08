package com.example.airport.service;

import com.example.airport.adapter.Adapter;
import com.example.airport.dto.ticket.TicketRegisterDTO;
import com.example.airport.dto.ticket.TicketViewDTO;
import com.example.airport.models.Flight;
import com.example.airport.models.FlightClass;
import com.example.airport.models.Ticket;
import com.example.airport.models.users.Visitor;
import com.example.airport.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final VisitorService visitorService;
    private final FlightService flightService;
    private final TicketRepository repository;

    public TicketService(VisitorService visitorService, FlightService flightService, TicketRepository repository) {
        this.visitorService = visitorService;
        this.flightService = flightService;
        this.repository = repository;
    }

    public TicketViewDTO buyTicket(TicketRegisterDTO ticketRegisterDTO){
        Flight flight = flightService.findFlightById(ticketRegisterDTO.getIdFlight());
        Visitor visitor = visitorService.findVisitorById(ticketRegisterDTO.getIdVisitor());

        for(FlightClass flightClass : flight.getFlightClasses()){
            if(flightClass.getClassEnum().getDescription().equalsIgnoreCase(ticketRegisterDTO.getClassSelected())){
                Ticket ticket = new Ticket(flightClass.getValueClass(), flight, flightClass.getClassEnum(), visitor);
                repository.save(ticket);
                flightService.updateSeatsFlightClass(flight, ticketRegisterDTO.getClassSelected());
                return Adapter.mapSourceToTarget(ticket, TicketViewDTO.class);
            }
        }
        return null;
    }
}
