package com.example.airport.service;

import com.example.airport.adapter.VisitorAdapter;
import com.example.airport.dto.visitor.VisitorRegisterDTO;
import com.example.airport.dto.visitor.VisitorViewDTO;
import com.example.airport.models.users.Visitor;
import com.example.airport.repository.VisitorRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    private final VisitorRepository repository;

    private final VisitorAdapter adapter;

    public VisitorService(VisitorRepository repository, VisitorAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    public VisitorViewDTO createVisitor(VisitorRegisterDTO visitorRegisterDTO){
        Visitor visitor = adapter.adapterRegisterVisitor(visitorRegisterDTO);
        repository.save(visitor);
        return adapter.adapterViewVisitor(visitor);
    }

    public Visitor findVisitorById(Long idVisitor){
        return repository.findById(idVisitor).orElseThrow(() -> new RuntimeException("Visitante não encontrado"));
    }
}
