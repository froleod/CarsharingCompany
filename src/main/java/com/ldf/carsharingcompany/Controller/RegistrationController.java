package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password) {
        // Создание нового пользователя
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
//        user.setPassword(passwordEncoder.encode(password)); // Хэширование пароля

        // Сохранение пользователя в базе данных
        userRepository.save(user);

        return "login"; // Перенаправление на страницу входа
    }
}
