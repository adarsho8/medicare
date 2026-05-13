package com.HealthCare.PatientService.controller;

import com.HealthCare.PatientService.dto.PatientDetailsDto;
import com.HealthCare.PatientService.entity.PatientDetails;
import com.HealthCare.PatientService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PatientService")
public class PatientController {
    @Autowired
    private PatientService service;
    @PostMapping("/addpatient")
    public String addPatient(@RequestBody PatientDetails patientDetails)
    {
        return service.registerPatient(patientDetails);

    }
    @GetMapping("/getpatientdetais")
    public List<PatientDetailsDto> getPatientDetails()
    {
        return service.getPatientDetails();
    }
    @GetMapping("/getpatientbyid/{id}")
    public PatientDetails getPatientDetailsById(@PathVariable int id)
    {
        return service.getPatientById(id);
    }

    @GetMapping("/getpatientbyname/{patientName}")
    public PatientDetails getPatientDetailsByName(@PathVariable String patientName)
    {
        return service.getPatientByName(patientName);
    }

}
