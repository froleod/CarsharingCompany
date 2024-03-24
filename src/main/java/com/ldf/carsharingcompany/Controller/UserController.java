//package com.ldf.carsharingcompany.Controller;
//
//import com.ldf.carsharingcompany.Entity.User;
//import com.ldf.carsharingcompany.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/register")
//    public String showRegistrationForm() {
//        return "registration";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user) {
//        userService.registerUser(user);
//        return "redirect:/login";
//    }
//}
