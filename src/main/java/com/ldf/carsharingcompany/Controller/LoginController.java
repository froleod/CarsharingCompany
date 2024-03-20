package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Возвращает страницу входа
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        // Проверка существования пользователя с указанным именем
        User user = userRepository.findByUsername(username);
        System.out.println(user.getUsername() + user.getPassword());
//        if (user == null) {
//            // Пользователь с указанным именем не найден
//            return "redirect:/login?error"; // Перенаправление с ошибкой
//        }

//        // Проверка совпадения паролей
//        if (!user.getPassword().equals(password)) {
//            // Пароль не совпадает
//            return "redirect:/login?error"; // Перенаправление с ошибкой
//        }

        // Если все проверки успешны, пользователь аутентифицирован
        // Здесь можно реализовать логику управления сессией и т.д.

        // Перенаправление на страницу после успешного входа
        return "redirect:/";
    }
}
