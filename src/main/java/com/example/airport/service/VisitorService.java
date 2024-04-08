package com.example.airport.service;

import com.example.airport.adapter.Adapter;
import com.example.airport.dto.visitor.VisitorRegisterDTO;
import com.example.airport.dto.visitor.VisitorViewDTO;
import com.example.airport.models.users.Visitor;
import com.example.airport.repository.VisitorRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    private final VisitorRepository repository;

    public VisitorService(VisitorRepository repository) {
        this.repository = repository;
    }

    public VisitorViewDTO createVisitor(VisitorRegisterDTO visitorRegisterDTO){
        Visitor visitor = Adapter.mapSourceToTarget(visitorRegisterDTO, Visitor.class);
        repository.save(visitor);
        return Adapter.mapSourceToTarget(visitor, VisitorViewDTO.class);
    }

    public Visitor findVisitorById(Long idVisitor){
        return repository.findById(idVisitor).orElseThrow(() -> new RuntimeException("Visitante não encontrado"));
    }
}
