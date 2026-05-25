package com.medicare.DoctorService.Service;

import com.medicare.DoctorService.Configuration.ModelMapper;
import com.medicare.DoctorService.Model.DoctorDetails;
import com.medicare.DoctorService.Repository.DoctorRepo;
import com.medicare.DoctorService.dto.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorManagementService {
    @Autowired
    private ModelMapper modelMapper;

    private final DoctorRepo doctorRepo;
    public DoctorManagementService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public String crateDoctor(DoctorDetails doctorDetails) {
        Optional<DoctorDetails> existingDoctor = doctorRepo.findById(doctorDetails.getDoctorId());
        if (existingDoctor.isPresent()) {
            throw new RuntimeException("Doctor already exists");
        }
        doctorRepo.save(doctorDetails);
        return "Doctor created";
    }
    public DoctorResponse getDoctorById(Long doctorId) {

        DoctorDetails doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));

        return modelMapper.map(doctor, DoctorResponse.class);
    }


}
