package com.example.smaap.domain.payment.repository;

import com.example.smaap.domain.payment.entity.CardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CardPaymentRepository extends JpaRepository<CardPayment, Long>, QuerydslPredicateExecutor<CardPayment> {
}
