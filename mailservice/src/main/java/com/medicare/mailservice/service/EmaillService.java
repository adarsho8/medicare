package com.medicare.mailservice.service;

import com.medicare.mailservice.dto.PatientDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmaillService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(PatientDetailsDto patientDetailsDto)
    {
        log.error("1");
        try {
            log.error("2");
            SimpleMailMessage mail = new SimpleMailMessage();
            log.error("3");
            mail.setTo(patientDetailsDto.getTo());
            System.out.println("patient email :"+patientDetailsDto.getTo());
            log.error("4");
            mail.setSubject("Welcome to Medicare Healthcare – Patient Registration Successful");
            log.error("5");
            String body =
                    "Dear " + patientDetailsDto.getPatientName() + ",\n\n" +
                            "Your patient account has been created successfully.\n\n" +
                            "Patient ID: " + patientDetailsDto.getPatientId() + "\n\n" +
                            "Thank you for choosing Medicare Healthcare.\n\n" +
                            "Regards,\n" +
                            "Medicare Healthcare Team";
            mail.setText(body);
            log.error("6");
            javaMailSender.send(mail);
            log.error("mail sent sucessfully");
        } catch (Exception e) {
            log.error("Exception while sending message");
            throw new RuntimeException(e);
        }


    }
}
