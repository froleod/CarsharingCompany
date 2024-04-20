package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Service.MyUserDetailService;
import com.ldf.carsharingcompany.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final MyUserDetailService userService;
    private final TripService tripService;

    @Autowired
    public ProfileController(MyUserDetailService userService, TripService tripService) {
        this.userService = userService;
        this.tripService = tripService;
    }

    @GetMapping("/profile")
    public String userProfile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        // Извлечение информации о пользователе из UserDetails
        String username = userDetails.getUsername();
        int tripCount = tripService.getTripCountForUser(username);
        // Передача информации о пользователе в представление
        model.addAttribute("username", username);
        model.addAttribute("tripCount", tripCount);

        return "profile";
    }

}
