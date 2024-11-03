package com.example.smaap.domain.region.service;

import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.domain.region.repository.NeighborhoodRepository;
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
}
