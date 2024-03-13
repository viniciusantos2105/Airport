package com.example.airport.models;

import com.example.airport.enums.FlightClassEnum;
import com.example.airport.models.users.Visitor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "flight_class", nullable = false)
    private FlightClassEnum flightClass;

    @ManyToOne
    @JoinColumn(name = "visitor", nullable = false)
    private Visitor visitor;
}
