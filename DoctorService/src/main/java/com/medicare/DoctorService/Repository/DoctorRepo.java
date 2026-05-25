package com.medicare.DoctorService.Repository;

import com.medicare.DoctorService.Model.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<DoctorDetails,Long> {
}
