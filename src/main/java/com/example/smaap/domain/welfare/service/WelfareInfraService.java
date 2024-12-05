package com.example.smaap.domain.welfare.service;

import com.example.smaap.domain.welfare.entity.QWelfareInfra;
import com.example.smaap.domain.welfare.entity.WelfareInfra;
import com.example.smaap.domain.welfare.repository.WelfareInfraRepository;
import com.example.smaap.domain.welfare.type.WelfareInfraType;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WelfareInfraService {
    private final WelfareInfraRepository welfareInfraRepository;

    public List<WelfareInfra> list(BigDecimal latitude, BigDecimal longitude, Long range, WelfareInfraType type) {
        QWelfareInfra qWelfareInfra = QWelfareInfra.welfareInfra;
        BooleanBuilder builder = new BooleanBuilder();

        if (latitude != null && longitude != null) {
            BigDecimal rangeValue = BigDecimal.valueOf(range).divide(BigDecimal.valueOf(1000));
            builder.and(qWelfareInfra.latitude.between(latitude.subtract(rangeValue), latitude.add(rangeValue))
                    .and(qWelfareInfra.longitude.between(longitude.subtract(rangeValue), longitude.add(rangeValue))));
        }

        if (type != null) {
            builder.and(qWelfareInfra.type.eq(type));
        }

        return (List<WelfareInfra>) welfareInfraRepository.findAll(builder);
    }
}
