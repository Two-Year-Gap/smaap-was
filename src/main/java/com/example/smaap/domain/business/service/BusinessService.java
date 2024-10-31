package com.example.smaap.domain.business.service;

import com.example.smaap.domain.business.entity.Business;
import com.example.smaap.domain.business.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessService {
    private final BusinessRepository businessRepository;

    public List<Business> list() {
        return businessRepository.findAll();
    }
}
