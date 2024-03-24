package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

//    @GetMapping("/trips")
//    public String showTrips(Model model, Authentication authentication) {
//        // Получаем имя текущего пользователя из аутентификации
//        String username = authentication.getName();
//
//        // Получаем только те поездки, которые принадлежат текущему пользователю
//        List<Trip> trips = jdbcTemplate.query(
//                "SELECT * FROM trip WHERE user_id = (SELECT id FROM users WHERE username = ?)",
//                new Object[]{username},
//                (rs, rowNum) -> new Trip(
//                        rs.getLong("trip_id"),
//                        rs.getString("car_name"),
//                        rs.getString("trip_time"),
//                        rs.getBigDecimal("trip_cost"),
//                        null  // Пользователь будет загружен отдельно
//                )
//        );
//
//        // Добавляем список поездок в модель
//        model.addAttribute("trips", trips);
//        return "trips";
//    }

}
