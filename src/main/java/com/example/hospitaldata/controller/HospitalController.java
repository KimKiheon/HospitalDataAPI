package com.example.hospitaldata.controller;

import com.example.hospitaldata.domain.dto.Hospital;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HospitalController {
    private Hospital hospital;

    public HospitalController(Hospital hospital) {
        this.hospital = hospital;
    }
}
