package com.HealthCare.PatientService.dto;

import lombok.Data;

@Data
public class PatientDetailsDto {
    private String patientName;
    private int age;
    private String mobileNo;
    private int patientId;
    private String bloodGroup;
    private String email;

}
