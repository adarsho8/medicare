package com.HealthCare.MedicareServer.exception;

public class UserExists  extends RuntimeException {
    public UserExists(String message) {
        super(message);
    }
}
