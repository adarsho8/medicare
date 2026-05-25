package com.HealthCare.MedicareServer.controller;

import com.HealthCare.MedicareServer.dto.LoginRequest;
import com.HealthCare.MedicareServer.jwt.JwtUtils;
import com.HealthCare.MedicareServer.model.User;
import com.HealthCare.MedicareServer.repository.UserRepo;
import com.HealthCare.MedicareServer.service.MyUserDetailsService;
import com.HealthCare.MedicareServer.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {

        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("Username already exists !!!");
        }

        return new ResponseEntity<>(
                userService.save(user),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/login")
    public String usrLogin(@Valid @RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        UserDetails userDetails= myUserDetailsService.loadUserByUsername(request.getUsername());
        if (authentication.isAuthenticated()) {
            return jwtUtils.generateToken(userDetails);
        }

        return "Authentication Failed";
    }
}