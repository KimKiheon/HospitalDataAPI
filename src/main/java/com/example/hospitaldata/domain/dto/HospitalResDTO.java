package com.example.hospitaldata.domain.dto;

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

    public static HospitalResDTO from(HospitalDTO hospital){
        HospitalResDTO dto = new HospitalResDTO();
        dto.hospitalName=hospital.getHospitalName();
        dto.fullAddress=hospital.getFullAddress();
        dto.roadNameAddress=hospital.getRoadNameAddress();
        dto.healthcareProviderCount = hospital.getHealthcareProviderCount();
        dto.patientRoomCount = hospital.getPatientRoomCount();
        dto.totalAreaSize = hospital.getTotalAreaSize();
        dto.shutDown = hospital.isShutdown();
        return dto;
    }

}
