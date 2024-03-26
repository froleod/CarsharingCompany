package com.ldf.carsharingcompany.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

//    @GetMapping("/")
//    public String home(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName(); // Получаем имя аутентифицированного пользователя
//        model.addAttribute("username", username);
//        return "home";
//    }
}
