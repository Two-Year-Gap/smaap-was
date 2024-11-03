package com.example.smaap.domain.business.repository;

import com.example.smaap.domain.business.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StoreRepository extends JpaRepository<Store, Long>, QuerydslPredicateExecutor<Store> {
}
