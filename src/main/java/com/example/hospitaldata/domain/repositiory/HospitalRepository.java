package com.example.hospitaldata.domain.repositiory;

import com.example.hospitaldata.domain.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {
}
