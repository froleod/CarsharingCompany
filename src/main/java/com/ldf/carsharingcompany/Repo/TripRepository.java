package com.ldf.carsharingcompany.Repo;

import com.ldf.carsharingcompany.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUserId(Long userId);
    List<Trip> findByUserUsername(String username);
}
