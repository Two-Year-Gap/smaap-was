package com.example.smaap.domain.region.repository;

import com.example.smaap.domain.region.entity.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long>, QuerydslPredicateExecutor<Neighborhood> {
    List<Neighborhood> findAllByDistrictId(Long districtId);
}
