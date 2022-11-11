package com.example.hospitaldata.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HospitalEntity {
    @Id
    private Integer id;
}
