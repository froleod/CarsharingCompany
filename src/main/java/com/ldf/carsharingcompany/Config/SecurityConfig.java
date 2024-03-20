//package com.ldf.carsharingcompany.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig implements WebMvcConfigurer {
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/register").setViewName("register"); // Указываем путь и имя представления
//    }
//}