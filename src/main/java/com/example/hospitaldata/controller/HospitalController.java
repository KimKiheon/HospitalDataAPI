package com.example.hospitaldata.controller;

import com.example.hospitaldata.dao.HospitalDao;
import com.example.hospitaldata.domain.dto.HospitalResDTO;
import com.example.hospitaldata.domain.entity.HospitalEntity;
import com.example.hospitaldata.domain.repositiory.HospitalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalRepository hospitalRepository;

    @GetMapping("")
    public String Hello() {
        return "Connection Test";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<HospitalEntity> hospitals = hospitalRepository.findAll();
        model.addAttribute("hospitals",hospitals);
        return "hospitals/list";
    }

}
