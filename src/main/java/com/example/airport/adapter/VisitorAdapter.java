package com.example.airport.adapter;

import com.example.airport.config.MapperConfig;
import com.example.airport.dto.visitor.VisitorRegisterDTO;
import com.example.airport.dto.visitor.VisitorViewDTO;
import com.example.airport.models.users.Visitor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VisitorAdapter {

    public final ModelMapper mapper = new MapperConfig().modelMapper();


    public Visitor adapterRegisterVisitor(VisitorRegisterDTO visitorRegisterDTO){
        return mapper.map(visitorRegisterDTO, Visitor.class);
    }

    public VisitorViewDTO adapterViewVisitor(Visitor visitor){
        return mapper.map(visitor, VisitorViewDTO.class);
    }
}
