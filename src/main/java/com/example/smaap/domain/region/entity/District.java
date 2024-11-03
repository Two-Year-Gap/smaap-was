package com.example.smaap.domain.region.entity;

import com.example.smaap.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class District extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "district")
    private List<Neighborhood> neighborhoods;

    @Builder
    public District(Region region, String name, List<Neighborhood> neighborhoods) {
        this.region = region;
        this.name = name;
        this.neighborhoods = neighborhoods;
    }
}
