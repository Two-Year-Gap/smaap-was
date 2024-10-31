package com.example.smaap.domain.business.entity;

import com.example.smaap.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Store extends BaseEntity {
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(name = "lot_number_address", length = 100)
    private String lotNumberAddress;

    @Column(name = "road_name_address", length = 100)
    private String readNameAddress;

    @Column(name = "latitude", precision = 12, scale = 10, nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 13, scale = 10, nullable = false)
    private BigDecimal longitude;

    public Store(String name, Business business, String lotNumberAddress, String readNameAddress, BigDecimal latitude, BigDecimal longitude) {
        this.name = name;
        this.business = business;
        this.lotNumberAddress = lotNumberAddress;
        this.readNameAddress = readNameAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
