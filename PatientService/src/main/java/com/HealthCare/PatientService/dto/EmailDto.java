package com.HealthCare.PatientService.dto;

import com.HealthCare.PatientService.repository.PatientRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


@Data
public class EmailDto {
    private String to;
    private String patientName;
    private int patientId;
}
