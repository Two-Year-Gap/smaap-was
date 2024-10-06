package com.example.smaap.application.business.entity;

import com.example.smaap.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Business extends BaseEntity {
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @OneToMany(mappedBy = "business")
    private List<Store> stores;

    @Builder
    public Business(String name, List<Store> stores) {
        this.name = name;
        this.stores = stores;
    }
}
