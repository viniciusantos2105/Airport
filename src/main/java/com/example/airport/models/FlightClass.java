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
    private Long idFlightClass;
    @Column(name = "class", nullable = false)
    private FlightClassEnum classEnum;
    @Column(name = "seats", nullable = false)
    private Integer seats;
    @Column(name = "value", nullable = false)
    private Double valueClass;

    public FlightClass(FlightClassEnum classEnum, Integer seats, Double valueClass) {
        this.classEnum = classEnum;
        this.seats = seats;
        this.valueClass = valueClass;
    }
}
