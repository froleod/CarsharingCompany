package com.ldf.carsharingcompany.Service;


import com.ldf.carsharingcompany.Config.MyUserDetails;
import com.ldf.carsharingcompany.Entity.User;
import com.ldf.carsharingcompany.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return new MyUserDetails(user);
    }
}
