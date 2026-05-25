package com.HealthCare.MedicareServer.exception;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class ErrorDetail {

    private LocalDateTime dateTime;
    private String message;
    public ErrorDetail(LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }
}
