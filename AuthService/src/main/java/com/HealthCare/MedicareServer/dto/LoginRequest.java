package com.HealthCare.MedicareServer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "username is empty")
    private String username;
    @NotBlank(message = "password required for login")
    private String password;
}
