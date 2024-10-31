package com.example.smaap.domain.business.entity;

import com.example.smaap.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Business extends BaseEntity {
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "business", fetch = FetchType.LAZY)
    private List<Store> stores;

    @Builder
    public Business(String name, List<Store> stores) {
        this.name = name;
        this.stores = stores;
    }
}
