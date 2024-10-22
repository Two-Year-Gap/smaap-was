package com.example.smaap.domain.welfare.entity;

import com.example.smaap.common.entity.BaseEntity;
import com.example.smaap.domain.welfare.type.WelfareInfraType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class WelfareInfra extends BaseEntity {
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private WelfareInfraType type;

    @Column(name = "lot_number_address", length = 100)
    private String lotNumberAddress;

    @Column(name = "road_name_address", length = 100)
    private String readNameAddress;

    @Column(name = "latitude", precision = 12, scale = 10, nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 13, scale = 10, nullable = false)
    private BigDecimal longitude;

    @Column(name = "location_explanation", length = 20)
    private String locationExplanation;

    @Builder
    public WelfareInfra(String name, WelfareInfraType type, String lotNumberAddress, String readNameAddress, BigDecimal latitude, BigDecimal longitude, String locationExplanation) {
        this.name = name;
        this.type = type;
        this.lotNumberAddress = lotNumberAddress;
        this.readNameAddress = readNameAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationExplanation = locationExplanation;
    }
}
