package com.example.airport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_iata")
    private Long codeIATA;

    @Column(name = "name_airport", nullable = false)
    private String nameAirport;

    @ManyToOne
    @JoinColumn(name = "city_airport", nullable = false)
    private City cityAirport;

    @OneToMany
    @JoinTable(name = "flights_airport",
        joinColumns = @JoinColumn(name = "code_iata_airport"),
        inverseJoinColumns = @JoinColumn(name = "flight_number"))
    private Set<Flight> flights;

    public Airport(String nameAirport, City cityAirport) {
        this.nameAirport = nameAirport;
        this.cityAirport = cityAirport;
    }
}
