package com.example.hospitaldata.service;

import com.example.hospitaldata.dao.HospitalDao;
import com.example.hospitaldata.domain.Hospital;
import com.example.hospitaldata.parser.ReadLineContext;

import java.io.IOException;
import java.util.List;

public class HospitalService {
    private final ReadLineContext<Hospital> hospitalReadLineContext;
    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    public void insertLargeVolumeHospitalData(String filename){
        try{
            List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
            for (Hospital hospital : hospitalList){
                try{
                    this.hospitalDao.add(hospital);
                }catch (Exception e){
                    System.out.printf("id: %d 레코드에 문제 존재",hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}
