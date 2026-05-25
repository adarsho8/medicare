package com.HealthCare.PatientService.service;

import com.HealthCare.PatientService.dto.SymptomRequest;
import com.HealthCare.PatientService.dto.SymptomResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentService {
    private final RestTemplate restTemplate;

    public AgentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SymptomResponse analyzeSymptom(
            SymptomRequest symptomRequest
    ){

        String url =
                "http://localhost:5678/webhook/symptom-analysis";

        return restTemplate.postForObject(
                url,
                symptomRequest,
                SymptomResponse.class
        );
    }
}