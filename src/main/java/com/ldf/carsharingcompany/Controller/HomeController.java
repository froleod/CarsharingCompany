package com.ldf.carsharingcompany.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String index() {
//        return "home";
//    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            model.addAttribute("username", username);
        }
        return "home";
    }
}
