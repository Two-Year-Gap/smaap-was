package com.example.smaap.domain.region.service;

import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.domain.region.repository.NeighborhoodRepository;
import com.example.smaap.presentation.dto.NeighborhoodCountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;

    public List<Neighborhood> list() {
        return neighborhoodRepository.findAll();
    }

    public List<Neighborhood> list(Long districtId) {
        return neighborhoodRepository.findAllByDistrictId(districtId);
    }

    public List<NeighborhoodCountDTO.Response> list(String popularType) {
        // 점포 수
        return neighborhoodRepository.findAllByStoreCountDesc();

        // 매출액
        // 유동 인구 수
        // 거주 인구 수
    }

    public Neighborhood read(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동입니다."));
    }
}
