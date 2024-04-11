package com.ldf.carsharingcompany.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="trip")
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "trip_time")
    private String tripTime;

    @Column(name = "trip_cost")
    private BigDecimal tripCost;

    @Column(name = "username")
    private String username;

//    public Trip(String carName, String tripTime, BigDecimal tripCost, String username) {
//        this.carName = carName;
//        this.tripTime = tripTime;
//        this.tripCost = tripCost;
//        this.username = username;
//    }

    public Trip(Long tripId, String carName, String tripTime, BigDecimal tripCost, String username) {
        this.tripId = tripId;
        this.carName = carName;
        this.tripTime = tripTime;
        this.tripCost = tripCost;
        this.username = username;
    }



    public Trip() {

    }
}
