package com.HealthCare.MedicareServer.service;

import com.HealthCare.MedicareServer.model.User;
import com.HealthCare.MedicareServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;
        public User save(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
        }
}
