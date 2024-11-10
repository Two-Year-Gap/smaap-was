package com.example.smaap.application.sales.service;

import com.example.smaap.application.sales.dto.SalesDto;
import com.example.smaap.domain.payment.entity.CardPayment;
import com.example.smaap.domain.payment.service.CardPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final CardPaymentService cardPaymentService;

    public SalesDto.Response read(SalesDto.Request dto) {
        List<CardPayment> cardPayments = cardPaymentService.list(
                dto.getYear(),
                dto.getNeighborhood(),
                dto.getBusiness()
        );

        return cardPayments.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(CardPayment::getTotalAmount),
                        Collectors.summingInt(CardPayment::getTotalUsage),
                        SalesDto.Response::of
                ));
    }
}
