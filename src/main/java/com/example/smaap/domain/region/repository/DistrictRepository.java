package com.example.smaap.domain.region.repository;

import com.example.smaap.domain.region.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findAllByRegionId(Long regionId);
}
