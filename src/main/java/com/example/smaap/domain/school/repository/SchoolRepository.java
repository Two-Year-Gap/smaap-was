package com.example.smaap.domain.school.repository;

import com.example.smaap.domain.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SchoolRepository extends JpaRepository<School, Long>, QuerydslPredicateExecutor<School> {
}
