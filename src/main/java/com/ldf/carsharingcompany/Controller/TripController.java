package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.Trip;
import com.ldf.carsharingcompany.Repo.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TripController {
    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/trips")
    public String showTrips(Model model, Authentication authentication) {
        // Получаем имя текущего пользователя из аутентификации
        String username = authentication.getName();

        // Получаем только те поездки, которые принадлежат текущему пользователю
        List<Trip> trips = tripRepository.findByUserUsername(username);

        // Добавляем список поездок в модель
        model.addAttribute("trips", trips);
        return "trips";
    }
}
