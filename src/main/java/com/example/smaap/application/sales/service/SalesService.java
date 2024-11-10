package com.example.smaap.application.sales.service;

import com.example.smaap.application.sales.dto.SalesDto;
import com.example.smaap.domain.business.entity.Business;
import com.example.smaap.domain.business.service.BusinessService;
import com.example.smaap.domain.payment.entity.CardPayment;
import com.example.smaap.domain.payment.service.CardPaymentService;
import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.domain.region.service.NeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final CardPaymentService cardPaymentService;
    private final NeighborhoodService neighborhoodService;
    private final BusinessService businessService;

    public SalesDto.Response read(SalesDto.Request dto) {
        Neighborhood neighborhood = neighborhoodService.read(dto.getNeighborhoodId());
        Business business = dto.getBusinessId() == null ? null : businessService.read(dto.getBusinessId());

        List<CardPayment> cardPayments = cardPaymentService.list(
                dto.getYear(),
                neighborhood,
                business
        );

        return cardPayments.stream()
                .collect(Collectors.teeing(
                        Collectors.summingLong(CardPayment::getTotalAmount),
                        Collectors.summingInt(CardPayment::getTotalUsage),
                        SalesDto.Response::of
                ));
    }
}
