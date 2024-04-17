package com.ldf.carsharingcompany.Service;


import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AppService {
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("User " + user + " is saved!");
    }
}