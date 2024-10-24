package com.example.smaap.domain.business.entity;

import com.example.smaap.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
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

    public Store(String name, Business business) {
        this.name = name;
        this.business = business;
    }
}
