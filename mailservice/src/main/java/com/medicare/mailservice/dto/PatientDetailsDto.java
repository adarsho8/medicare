package com.medicare.mailservice.dto;

import lombok.Data;

@Data
public class PatientDetailsDto {
    private String to;
    private String patientName;
    private int patientId;

}
