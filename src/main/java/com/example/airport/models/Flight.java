package com.example.airport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightNumber;

    @ManyToOne
    @JoinColumn(name = "origin_airport", nullable = false)
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destination_airport", nullable = false)
    private Airport destinationAirport;

    @Column(name = "departure_date_time", nullable = false)
    private Date departureDateTime;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "flight_classes",
        joinColumns = @JoinColumn(name = "flight_number"))
    private List<FlightClass> flightClasses = new ArrayList<>();


    public void addFlightClass(FlightClass flightClass){
        flightClasses.add(flightClass);
    }

    public Flight(Airport originAirport, Airport destinationAirport, Date departureDateTime) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureDateTime = departureDateTime;
    }
}
