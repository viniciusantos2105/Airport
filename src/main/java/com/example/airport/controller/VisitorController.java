package com.example.airport.controller;

import com.example.airport.dto.flight.FlightRegisterDTO;
import com.example.airport.dto.flight.FlightViewDTO;
import com.example.airport.dto.visitor.VisitorRegisterDTO;
import com.example.airport.dto.visitor.VisitorViewDTO;
import com.example.airport.models.users.Visitor;
import com.example.airport.service.FlightService;
import com.example.airport.service.VisitorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/create")
    public ResponseEntity<VisitorViewDTO> create(@RequestBody @Valid VisitorRegisterDTO visitorRegisterDTO) throws ParseException {
        VisitorViewDTO visitor = visitorService.createVisitor(visitorRegisterDTO);
        return ResponseEntity.ok().body(visitor);
    }
}
