package com.example.hospitaldata.domain.dto;

import com.example.hospitaldata.domain.Hospital;
import lombok.Getter;

@Getter
public class HospitalResDTO {
    private String hospitalName;
    private String fullAddress;
    private String roadNameAddress;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private float totalAreaSize;
    private boolean shutDown;

    public static HospitalResDTO from(Hospital hospital){
        HospitalResDTO dto = new HospitalResDTO();
        dto.hospitalName=getHospitalName();
        dto.fullAddress=getFullAddress();
        dto.roadNameAddress=getRoadNameAddress();
        dto.healthcareProviderCount = hospital.getHealthcareProviderCount();
        dto.patientRoomCount = hospital.getPatientRoomCount();
        dto.totalAreaSize = hospital.getTotalAreaSize();
        dto.shutDown = hospital.isShutdown();
        return dto;
    }

}
