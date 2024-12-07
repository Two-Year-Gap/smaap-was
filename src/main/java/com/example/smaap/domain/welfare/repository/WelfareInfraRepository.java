package com.example.smaap.domain.welfare.repository;

import com.example.smaap.domain.welfare.entity.WelfareInfra;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface WelfareInfraRepository extends JpaRepository<WelfareInfra, Long>, QuerydslPredicateExecutor<WelfareInfra> {
    default List<WelfareInfra> findAll(Predicate predicate, int size) {
        return findAll((Predicate) predicate, (Pageable) PageRequest.of(0, size)).getContent();
    }
}
