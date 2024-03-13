package com.example.airport.models;

import com.example.airport.enums.FlightClassEnum;
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
public class FlightClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class", nullable = false)
    private FlightClassEnum classEnum;
    @Column(name = "seats", nullable = false)
    private Integer seats;

    public FlightClass(FlightClassEnum classEnum, Integer seats) {
        this.classEnum = classEnum;
        this.seats = seats;
    }
}
