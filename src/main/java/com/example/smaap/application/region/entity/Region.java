package com.example.smaap.application.region.entity;

import com.example.smaap.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Region extends BaseEntity {
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "region")
    private List<District> districts;

    public Region(String name, List<District> districts) {
        this.name = name;
        this.districts = districts;
    }
}
