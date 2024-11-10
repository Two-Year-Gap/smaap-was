package com.example.smaap.domain.business.service;

import com.example.smaap.domain.business.entity.QStore;
import com.example.smaap.domain.business.entity.Store;
import com.example.smaap.domain.business.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<Store> list(Long businessId, String address, BigDecimal latitude, BigDecimal longitude, Long range, int size) {
        QStore qStore = QStore.store;
        BooleanBuilder builder = new BooleanBuilder();

        if (businessId != null) {
            builder.and(qStore.business.id.eq(businessId));
        }

        if (address != null && !address.isEmpty()) {
            builder.and(qStore.lotNumberAddress.containsIgnoreCase(address)
                    .or(qStore.readNameAddress.containsIgnoreCase(address)));
        }

        if (latitude != null && longitude != null) {
            BigDecimal rangeValue = BigDecimal.valueOf(range).divide(BigDecimal.valueOf(1000));
            builder.and(qStore.latitude.between(latitude.subtract(rangeValue), latitude.add(rangeValue))
                    .and(qStore.longitude.between(longitude.subtract(rangeValue), longitude.add(rangeValue))));
        }

        return (List<Store>) storeRepository.findAll(builder, size);
    }
}