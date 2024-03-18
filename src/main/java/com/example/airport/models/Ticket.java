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
    private Long ticketNumber;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "flight_class", nullable = false)
    private FlightClassEnum flightClass;

    @ManyToOne
    @JoinColumn(name = "flight", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "visitor", nullable = false)
    private Visitor visitor;

    public Ticket(Double price,Flight flight, FlightClassEnum flightClass, Visitor visitor) {
        this.price = price;
        this.flight = flight;
        this.flightClass = flightClass;
        this.visitor = visitor;
    }


}
