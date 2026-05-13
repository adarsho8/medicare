package com.HealthCare.PatientService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "PatientDetails")
public class PatientDetails implements Serializable {//implementing serializable for using redis caching to use @caching
    @NotBlank
    private String patientName;
    @NotNull
    private int age;
    @NotBlank
    private String mobileNo;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;
    private String bloodGroup;
    @Column(unique = true)
    private String email;
    private String password;
}
