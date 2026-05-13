package com.HealthCare.PatientService.service;

import com.HealthCare.PatientService.dto.EmailDto;
import com.HealthCare.PatientService.dto.PatientDetailsDto;
import com.HealthCare.PatientService.entity.PatientDetails;
import com.HealthCare.PatientService.repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PatientService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PatientRepo repo;
    @Autowired
    private WebClient.Builder webclient;
    public String registerPatient(PatientDetails patientDetails)
    {
        Optional<PatientDetails> existingPatient =
                repo.findByEmail(patientDetails.getEmail());

        if(existingPatient.isPresent())
        {
            return "Patient already exists";
        }

        PatientDetails details = repo.save(patientDetails);

        EmailDto emailDto = new EmailDto();

        emailDto.setPatientId(details.getPatientId());
        emailDto.setTo(details.getEmail());
        emailDto.setPatientName(details.getPatientName());

        String mail = webclient
                .baseUrl("http://mailservice")
                .build()
                .post()
                .uri("/email/welcomeletter")
                .bodyValue(emailDto)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info("Mail response : {}", mail);

        return "Patient created successfully";
    }
    //getAllPatientDetails
    public List<PatientDetailsDto> getPatientDetails()
    {
        List<PatientDetails> details=repo.findAll();
        List<PatientDetailsDto> detailsDtos=details.stream()
                .map(detail->mapper.map(detail,PatientDetailsDto.class))
                .toList();
        return detailsDtos;
    }
    //getPatientByID
    @Cacheable(value = "PatientDetails",key = "#patientid")
    public PatientDetails getPatientById(int patientid)
    {
        log.error("getting details from db");

        PatientDetails details=repo.findById(patientid).orElseThrow(()->new RuntimeException("Patient not found with id :"+patientid));
        return details;
    }
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    public PatientDetails getPatientByName(String patientName)
    {
        PatientDetails reddis=(PatientDetails) redisTemplate.opsForValue().get(patientName);
        if(reddis!=null)
        {
            log.error("getting details from reddis");
            return reddis;
        }
        log.error("getting details from db");

        PatientDetails patientDetails=repo.findBypatientName(patientName);
        redisTemplate.opsForValue().set(patientName,patientDetails,5, TimeUnit.MINUTES);
        return patientDetails;
    }
}
