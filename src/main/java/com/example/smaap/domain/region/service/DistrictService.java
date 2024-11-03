package com.example.smaap.domain.region.service;

import com.example.smaap.domain.region.entity.District;
import com.example.smaap.domain.region.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;

    public List<District> list() {
        return districtRepository.findAll();
    }
}
