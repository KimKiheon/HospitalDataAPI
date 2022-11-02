package com.example.hospitaldata.controller;

import com.example.hospitaldata.dao.HospitalDao;
import com.example.hospitaldata.domain.dto.HospitalResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalDao hospitaldao;
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResDTO> findById(@PathVariable("id")int id){
        return ResponseEntity.ok(HospitalResDTO
                .from(hospitaldao.findById(id)));
    }

}
