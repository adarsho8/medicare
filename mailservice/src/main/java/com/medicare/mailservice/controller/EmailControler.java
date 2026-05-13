package com.medicare.mailservice.controller;

import com.medicare.mailservice.dto.PatientDetailsDto;
import com.medicare.mailservice.service.EmaillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailControler {
    @Autowired
    private EmaillService service;

    @PostMapping("/welcomeletter")
    public String sendemail(@RequestBody PatientDetailsDto patientDetailsDto)
    {

        service.sendEmail(patientDetailsDto);
        return "mail sent successfully";
    }
}
