package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private AppService appService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("username") String username,
                          @ModelAttribute("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles("ROLE_USER"); // default role is "USER"
        appService.addUser(user);
        return "redirect:/login";
    }
}
