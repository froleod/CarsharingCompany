package com.ldf.carsharingcompany.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class BookingController {
    @PostMapping("/booking")
    public String goToBookingPage(@RequestParam("carName") String carName,
                                  @RequestParam("carPrice") String carPrice,
                                  HttpServletRequest request) {
        return "booking";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/processBooking")
    public String processBooking(@RequestParam("carName") String carName,
                                 @RequestParam("carPrice") String carPrice,
                                 @RequestParam("tripDuration") String tripDuration,
                                 HttpServletRequest request) {

//        System.out.println(carName + " " + tripDuration + " " + carPrice);

        String[] durationParts = tripDuration.split(":");

        Double minutes = Double.parseDouble(durationParts[0]) + Double.parseDouble(durationParts[1]) / 60;

        String priceSubstring = carPrice.substring(0, 2);
        int carPriceInt = Integer.parseInt(priceSubstring);

        BigDecimal carPriceDecimal = new BigDecimal(carPriceInt);

//        System.out.println(minutes);

        BigDecimal tripCostDecimal = carPriceDecimal.multiply(BigDecimal.valueOf(minutes));

//        System.out.println(carName + " " + tripDuration + " " + tripCostDecimal);

        jdbcTemplate.update("INSERT INTO trip (car_name, trip_time, trip_cost) VALUES (?, ?, ?)",
                carName, tripDuration, tripCostDecimal);

        return "redirect:/";
    }

}
