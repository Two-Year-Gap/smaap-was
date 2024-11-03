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

    public List<Store> list(Long businessId, String address, BigDecimal latitude, BigDecimal longitude, Long range) {
        QStore qStore = QStore.store;
        BooleanBuilder builder = new BooleanBuilder();

        if (businessId != null) {
            builder.and(qStore.business.id.eq(businessId));
        }

        if (address != null && !address.isEmpty()) {
            builder.and(qStore.lotNumberAddress.containsIgnoreCase(address)
                    .or(qStore.readNameAddress.containsIgnoreCase(address)));
        }

        if (latitude != null && longitude != null && range != null) {
            double rangeInDegree = range / 111.12;
            double minLatitude = latitude.doubleValue() - rangeInDegree;
            double maxLatitude = latitude.doubleValue() + rangeInDegree;
            double minLongitude = longitude.doubleValue() - rangeInDegree;
            double maxLongitude = longitude.doubleValue() + rangeInDegree;

            builder.and(qStore.latitude.between(BigDecimal.valueOf(minLatitude), BigDecimal.valueOf(maxLatitude))
                    .and(qStore.longitude.between(BigDecimal.valueOf(minLongitude), BigDecimal.valueOf(maxLongitude))));
        }

        return (List<Store>) storeRepository.findAll(builder);
    }
}
