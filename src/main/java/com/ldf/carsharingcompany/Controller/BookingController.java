package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.Trip;
import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Repo.TripRepository;
import com.ldf.carsharingcompany.Repo.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class BookingController {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/booking")
    public String goToBookingPage(@RequestParam("carName") String carName,
                                  @RequestParam("carPrice") String carPrice,
                                  HttpServletRequest request) {
        return "booking";
    }



    @PostMapping("/processBooking")
    public String processBooking(@RequestParam("carName") String carName,
                                 @RequestParam("carPrice") String carPrice,
                                 @RequestParam("tripDuration") String tripDuration) {
        String[] durationParts = tripDuration.split(":");
        Double minutes = Double.parseDouble(durationParts[0]) + Double.parseDouble(durationParts[1]) / 60;
        BigDecimal carPriceDecimal = new BigDecimal(carPrice.substring(0, 2));
        BigDecimal tripCostDecimal = carPriceDecimal.multiply(BigDecimal.valueOf(minutes));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (user != null) {
            Trip newTrip = new Trip(carName, tripDuration, tripCostDecimal, user);
            tripRepository.save(newTrip);
        }

        return "redirect:/";
    }

}
