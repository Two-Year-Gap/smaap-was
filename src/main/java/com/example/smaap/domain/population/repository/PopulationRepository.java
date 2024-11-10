package com.example.smaap.domain.population.repository;

import com.example.smaap.domain.population.entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PopulationRepository extends JpaRepository<Population, Long>, QuerydslPredicateExecutor<Population> {
}
