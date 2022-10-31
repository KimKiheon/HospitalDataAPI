package com.example.hospitaldata.parser;

import com.example.hospitaldata.domain.dto.Hospital;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HospitalParser implements  Parser<Hospital> {
    @Override
    public Hospital parse(String str) {
        String[] row = str.split("\",\"");
        System.out.println(Arrays.toString(row));
        Hospital hospital = new Hospital();
        hospital.setId(Integer.parseInt(row[0].replace("\n","")));


        hospital.setId(Integer.parseInt(row[0]));
        hospital.setOpenServiceName(row[1]);
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[2]));
        hospital.setManagementNumber(row[3]);
        hospital.setLicenseDate(LocalDateTime.parse((row[4])));
        hospital.setBusinessStatus(Integer.parseInt(row[5]));
        hospital.setBusinessStatusCode(Integer.parseInt(row[6]));
        hospital.setPhone(Integer.parseInt(row[7]));
        hospital.setFullAddress(row[8]);
        hospital.setRoadNameAddress(row[9]);
        hospital.setHospitalName(row[10]);
        hospital.setBusinessTypeName(row[11]);
        hospital.setHealthcareProviderCount(Integer.parseInt(row[12]));
        hospital.setPatientRoomCount(Integer.parseInt(row[13]));
        hospital.setTotalNumberOfBeds(Integer.parseInt(row[14]));
        hospital.setTotalAreaSize(Integer.parseInt(row[15]));
        return null;
    }
}
