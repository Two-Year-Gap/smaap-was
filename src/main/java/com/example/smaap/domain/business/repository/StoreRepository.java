package com.example.smaap.domain.business.repository;

import com.example.smaap.domain.business.entity.Store;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface StoreRepository extends JpaRepository<Store, Long>, QuerydslPredicateExecutor<Store> {
    default List<Store> findAll(Predicate predicate, int size) {
        return findAll((Predicate) predicate, (Pageable) PageRequest.of(0, size)).getContent();
    }
}
