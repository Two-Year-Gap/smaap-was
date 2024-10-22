package com.example.smaap.domain.school.entity;

import com.example.smaap.common.entity.BaseEntity;
import com.example.smaap.domain.school.type.SchoolGenderType;
import com.example.smaap.domain.school.type.SchoolType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class School extends BaseEntity {
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "student_count", nullable = false)
    private Long studentCount;

    @Column(name = "employee_count", nullable = false)
    private Long employeeCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private SchoolType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private SchoolGenderType gender;

    @Column(name = "lot_number_address", length = 100)
    private String lotNumberAddress;

    @Column(name = "lot_number_zip_code", length = 6)
    private String lotNumberZipCode;

    @Column(name = "road_name_address", length = 100)
    private String readNameAddress;

    @Column(name = "road_name_zip_code", length = 5)
    private String readNameZipCode;

    @Column(name = "latitude", precision = 12, scale = 10, nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 13, scale = 10, nullable = false)
    private BigDecimal longitude;

    @Builder

    public School(String name, Long studentCount, Long employeeCount, SchoolType type, SchoolGenderType gender, String lotNumberAddress, String lotNumberZipCode, String readNameAddress, String readNameZipCode, BigDecimal latitude, BigDecimal longitude) {
        this.name = name;
        this.studentCount = studentCount;
        this.employeeCount = employeeCount;
        this.type = type;
        this.gender = gender;
        this.lotNumberAddress = lotNumberAddress;
        this.lotNumberZipCode = lotNumberZipCode;
        this.readNameAddress = readNameAddress;
        this.readNameZipCode = readNameZipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
