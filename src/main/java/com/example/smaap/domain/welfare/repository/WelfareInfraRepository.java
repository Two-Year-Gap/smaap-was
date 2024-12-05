package com.example.smaap.domain.welfare.repository;

import com.example.smaap.domain.welfare.entity.WelfareInfra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WelfareInfraRepository extends JpaRepository<WelfareInfra, Long>, QuerydslPredicateExecutor<WelfareInfra> {
}
