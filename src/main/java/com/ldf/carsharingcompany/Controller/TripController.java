package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TripController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/trips")
    public String showTrips(Model model) {
        List<Trip> trips = jdbcTemplate.query(
                "SELECT * FROM trip",
                (rs, rowNum) -> new Trip(
                        rs.getLong("trip_id"),
                        rs.getString("car_name"),
                        rs.getString("trip_time"),
                        rs.getBigDecimal("trip_cost")
                )
        );
        model.addAttribute("trips", trips);
        return "trips";
    }
}
