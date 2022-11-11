package com.example.hospitaldata.service;

import com.example.hospitaldata.dao.HospitalDao;
import com.example.hospitaldata.domain.dto.HospitalDTO;
import com.example.hospitaldata.parser.ReadLineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class HospitalService {
    private final ReadLineContext<HospitalDTO> hospitalReadLineContext;
    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<HospitalDTO> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    @Transactional
    public int insertLargeVolumeHospitalData(String filename) {
        int cnt=0;
        try {
            List<HospitalDTO> hospitalList = hospitalReadLineContext.readByLine(filename);
            for (HospitalDTO hospital : hospitalList) {
                try {
                    this.hospitalDao.add(hospital);
                    cnt++;
                } catch (Exception e) {
                    System.out.printf("id: %d 레코드에 문제 존재", hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

}
