package com.example.smaap.domain.region.repository;

import com.example.smaap.domain.region.entity.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    List<Neighborhood> findAllByDistrictId(Long districtId);
}
