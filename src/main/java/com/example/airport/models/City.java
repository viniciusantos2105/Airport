package com.example.airport.models;

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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_city", nullable = false)
    private String nameCity;
    @Column(name = "federative_unit", nullable = false)
    private String federativUnit;

    public City(String nameCity, String federativUnit) {
        this.nameCity = nameCity;
        this.federativUnit = federativUnit;
    }
}
