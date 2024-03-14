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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "flights_origin_airport",
        joinColumns = @JoinColumn(name = "code_iata_airport"),
        inverseJoinColumns = @JoinColumn(name = "flight_number"))
    private Set<Flight> originFlights ;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "flights_destination_airport",
            joinColumns = @JoinColumn(name = "code_iata_airport"),
            inverseJoinColumns = @JoinColumn(name = "flight_number"))
    private Set<Flight> destinationFlights;

    public Airport(String nameAirport, City cityAirport) {
        this.nameAirport = nameAirport;
        this.cityAirport = cityAirport;
    }
}
