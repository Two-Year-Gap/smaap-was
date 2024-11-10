package com.example.smaap.domain.payment.service;

import com.example.smaap.domain.business.entity.Business;
import com.example.smaap.domain.payment.entity.CardPayment;
import com.example.smaap.domain.payment.entity.QCardPayment;
import com.example.smaap.domain.payment.repository.CardPaymentRepository;
import com.example.smaap.domain.region.entity.Neighborhood;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardPaymentService {
    private final CardPaymentRepository cardPaymentRepository;

    public List<CardPayment> list(Integer year, Neighborhood neighborhood, Business business) {
        QCardPayment qCardPayment = QCardPayment.cardPayment;
        BooleanBuilder builder = new BooleanBuilder();

        if (year != null) {
            builder.and(qCardPayment.year.eq(year));
        }
        if (neighborhood != null) {
            builder.and(qCardPayment.neighborhood.eq(neighborhood));
        }
        if (business != null) {
            builder.and(qCardPayment.business.eq(business));
        }

        return (List<CardPayment>) cardPaymentRepository.findAll(builder);
    }
}
