package com.example.hospitaldata.controller;

import com.example.hospitaldata.dao.HospitalDao;
import com.example.hospitaldata.domain.dto.HospitalResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalDao hospitaldao;
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResDTO> findById(@PathVariable("id")int id){
        return ResponseEntity.ok(HospitalResDTO
                .from(hospitaldao.findById(id)));
    }
    @GetMapping("/")
    public String Hello() {
        return "Connection Test";
    }


}
