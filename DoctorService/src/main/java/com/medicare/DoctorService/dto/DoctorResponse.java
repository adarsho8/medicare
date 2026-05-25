package com.medicare.DoctorService.dto;

import com.medicare.DoctorService.enums.ConsultionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class DoctorResponse {

        private Long doctorId;
        private String doctorName;
        private String email;
        private String phone;
        private String specialization;
        private Integer experience;
        private String qualification;
        private String hospitalName;
        private Double consultationFee;
        @Enumerated(EnumType.STRING)
        private ConsultionType consultationType;
        private Boolean active;
    }
}
