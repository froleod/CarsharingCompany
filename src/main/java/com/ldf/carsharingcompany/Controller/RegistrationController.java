package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private AppService appService;

//    @GetMapping("/registration")
//    public String registration(){
//        return "registration";
//    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody User user){
        appService.addUser(user);
        return "User is saved!";
    }
}
