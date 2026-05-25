package com.medicare.DoctorService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DoctorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private String email;
    private String mobile;
    private String specilization;
    private Integer experience;
    private String qualification;
    private String hospitalName;
    private Double consultionFee;
    private String consultionType;
    private Boolean gender;
    private String address;

}
