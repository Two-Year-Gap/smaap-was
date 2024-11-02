package com.example.smaap.domain.region.service;

import com.example.smaap.domain.region.entity.Region;
import com.example.smaap.domain.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    public List<Region> list() {
        return regionRepository.findAll();
    }
}
