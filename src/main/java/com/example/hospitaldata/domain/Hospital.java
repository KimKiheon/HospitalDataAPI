package com.example.hospitaldata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Hospital {
    private int id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;

    public boolean isShutdown(){
        return businessStatus == 3 || businessStatusCode == 3;
    }

    public String getInsertQuery(){
        String sql = String.format("insert into hospitals (id, open_service_name, open_local_government_code, " +
                        "management_number, license_date, business_status, business_status_code, phone " +
                        "full_address, road_name_address, hospital_name, business_type_name, healthcare_provider_count, " +
                        "patient_room_count, total_number_of_beds, total_area_size)" +
                        "values \n" +
                        "(\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\", \n" +
                        "\"%s\");",this.id, this.openServiceName, this.openLocalGovernmentCode,
                this.managementNumber, this.licenseDate, this.businessStatus,this.businessStatusCode,this.phone,
                this.fullAddress, this.roadNameAddress, this.hospitalName, this.businessTypeName, this.healthcareProviderCount,
                this.patientRoomCount, this.totalNumberOfBeds, this.totalAreaSize);
        return sql;
    }

}
