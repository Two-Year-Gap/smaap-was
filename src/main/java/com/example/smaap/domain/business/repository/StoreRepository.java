package com.example.smaap.domain.business.repository;

import com.example.smaap.domain.business.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
