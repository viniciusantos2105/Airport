package com.example.airport.adapter;

import com.example.airport.config.MapperConfig;
import com.example.airport.dto.ticket.TicketViewDTO;
import com.example.airport.dto.visitor.VisitorRegisterDTO;
import com.example.airport.dto.visitor.VisitorViewDTO;
import com.example.airport.models.Ticket;
import com.example.airport.models.users.Visitor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketAdapter {

    public final ModelMapper mapper = new MapperConfig().modelMapper();


    public TicketViewDTO adapterViewTicketDTO(Ticket ticket){
        TicketViewDTO dto = mapper.map(ticket, TicketViewDTO.class);
        dto.getVisitorViewTicketDTO().setCpf(ticket.getVisitor().getCpf());
        dto.getVisitorViewTicketDTO().setName(ticket.getVisitor().getName());
        dto.getVisitorViewTicketDTO().setEmail(ticket.getVisitor().getEmail());
        return dto;
    }

}
