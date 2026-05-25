package com.medicare.DoctorService.dto;

import com.medicare.DoctorService.enums.ConsultionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class DoctorUpdate {

        private String phone;
        private String specialization;
        private Integer experience;
        private String qualification;
        private String hospitalName;
        private Double consultationFee;
        @Enumerated(EnumType.STRING)
        private ConsultionType consultationType;
        private String address;
}
