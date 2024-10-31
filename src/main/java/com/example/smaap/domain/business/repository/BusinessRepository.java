package com.example.smaap.domain.business.repository;

import com.example.smaap.domain.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
