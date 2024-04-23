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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Trip(Long tripId, String carName, String tripTime, BigDecimal tripCost, User user) {
        this.tripId = tripId;
        this.carName = carName;
        this.tripTime = tripTime;
        this.tripCost = tripCost;
        this.user = user;
    }

    public Trip() {

    }

    public Trip(String carName, String tripDuration, BigDecimal tripCostDecimal, User user) {
        this.carName = carName;
        this.tripTime = tripDuration;
        this.tripCost = tripCostDecimal;
        this.user = user;
    }
}
