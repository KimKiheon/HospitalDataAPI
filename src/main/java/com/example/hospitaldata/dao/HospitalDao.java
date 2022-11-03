package com.example.hospitaldata.dao;

import com.example.hospitaldata.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Hospital> rowMapper = (rs, rowNum) ->
            new Hospital(Integer.valueOf(rs.getString("id")),
                    rs.getString("open_service_name"),
                    Integer.valueOf(rs.getString("open_local_government_code")),
                    rs.getString("management_number"),
                    rs.getTimestamp("license_date").toLocalDateTime(),
                    Integer.valueOf(rs.getString("business_status")),
                    Integer.valueOf(rs.getString("business_status_code")),
                    rs.getString("phone"),
                    rs.getString("full_address"),
                    rs.getString("road_name_address"),
                    rs.getString("hospital_name"),
                    rs.getString("business_type_name"),
                    Integer.valueOf(rs.getString("healthcare_provider_count")),
                    Integer.valueOf(rs.getString("patient_room_count")),
                    Integer.valueOf(rs.getString("total_number_of_beds")),
                    Float.valueOf(rs.getString("total_area_size")));

    public void add(Hospital hospital) {
        String sql = "INSERT INTO hospitals (id, open_service_name, open_local_government_code, management_number, license_date, business_status, business_status_code, phone, full_address, road_name_address, hospital_name, business_type_name, healthcare_provider_count, patient_room_count, total_number_of_beds, total_area_size)" +
                " VALUES (?,?,?,?," +
                " ?,?,?,?," +
                " ?,?,?,?," +
                " ?,?,?,?);"; // 16개
        this.jdbcTemplate.update(sql,
                hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(), hospital.getManagementNumber(),
                hospital.getLicenseDate(), hospital.getBusinessStatus(), hospital.getBusinessStatusCode(), hospital.getPhone(),
                hospital.getFullAddress(), hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize()
        );
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from hospitals");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from hospitals;", Integer.class);
    }

    public Hospital findById(int id) {
        return jdbcTemplate.queryForObject("select *from hospitals where id = ?", rowMapper, id);
    }

    public List<Hospital> findAll() {
        return jdbcTemplate.query("SELECT * FROM nation_wide_hospitals", rowMapper);
    }


}
