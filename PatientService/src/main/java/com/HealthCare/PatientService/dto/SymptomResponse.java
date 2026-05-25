package com.HealthCare.PatientService.dto;

import lombok.Data;

@Data
public class SymptomResponse {

    private String possibleCondition;
    private String severity;
    private String precautions;
    private String homeRemedies;
    private String suggestedMedicines;
    private String recommendedSpecialist;
}