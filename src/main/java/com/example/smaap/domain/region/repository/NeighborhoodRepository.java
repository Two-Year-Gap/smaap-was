package com.example.smaap.domain.region.repository;

import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.presentation.dto.NeighborhoodCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    List<Neighborhood> findAllByDistrictId(Long districtId);

    @Query(
            "SELECT new com.example.smaap.presentation.dto.NeighborhoodCountDTO.Response(" +
                    "n.id, n.name, COUNT(s.id)) " +
                    "FROM Neighborhood n " +
                    "LEFT JOIN n.district s " + // n.district -> n.stopres로 수정 필요
                    "GROUP BY n.id, n.name " +
                    "ORDER BY COUNT(s.id) DESC"
    )
    List<NeighborhoodCountDTO.Response> findAllByStoreCountDesc();
}
