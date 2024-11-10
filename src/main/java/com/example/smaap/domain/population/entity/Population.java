package com.example.smaap.domain.population.entity;


import com.example.smaap.common.entity.BaseEntity;
import com.example.smaap.domain.population.type.PopulationType;
import com.example.smaap.domain.region.entity.Neighborhood;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
public class Population extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "neighborhood_id", nullable = false)
    private Neighborhood neighborhood;

    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    @Column(name = "month", nullable = false, length = 2)
    private Integer month;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PopulationType type;

    @Column(name = "latitude", precision = 12, scale = 10, nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 13, scale = 10, nullable = false)
    private BigDecimal longitude;

    @Column(name = "t_00", precision = 10, scale = 6)
    private BigDecimal population00;

    @Column(name = "t_01", precision = 10, scale = 6)
    private BigDecimal population01;

    @Column(name = "t_02", precision = 10, scale = 6)
    private BigDecimal population02;

    @Column(name = "t_03", precision = 10, scale = 6)
    private BigDecimal population03;

    @Column(name = "t_04", precision = 10, scale = 6)
    private BigDecimal population04;

    @Column(name = "t_05", precision = 10, scale = 6)
    private BigDecimal population05;

    @Column(name = "t_06", precision = 10, scale = 6)
    private BigDecimal population06;

    @Column(name = "t_07", precision = 10, scale = 6)
    private BigDecimal population07;

    @Column(name = "t_08", precision = 10, scale = 6)
    private BigDecimal population08;

    @Column(name = "t_09", precision = 10, scale = 6)
    private BigDecimal population09;

    @Column(name = "t_10", precision = 10, scale = 6)
    private BigDecimal population10;

    @Column(name = "t_11", precision = 10, scale = 6)
    private BigDecimal population11;

    @Column(name = "t_12", precision = 10, scale = 6)
    private BigDecimal population12;

    @Column(name = "t_13", precision = 10, scale = 6)
    private BigDecimal population13;

    @Column(name = "t_14", precision = 10, scale = 6)
    private BigDecimal population14;

    @Column(name = "t_15", precision = 10, scale = 6)
    private BigDecimal population15;

    @Column(name = "t_16", precision = 10, scale = 6)
    private BigDecimal population16;

    @Column(name = "t_17", precision = 10, scale = 6)
    private BigDecimal population17;

    @Column(name = "t_18", precision = 10, scale = 6)
    private BigDecimal population18;

    @Column(name = "t_19", precision = 10, scale = 6)
    private BigDecimal population19;

    @Column(name = "t_20", precision = 10, scale = 6)
    private BigDecimal population20;

    @Column(name = "t_21", precision = 10, scale = 6)
    private BigDecimal population21;

    @Column(name = "t_22", precision = 10, scale = 6)
    private BigDecimal population22;

    @Column(name = "t_23", precision = 10, scale = 6)
    private BigDecimal population23;

    public Population(Neighborhood neighborhood, Integer year, Integer month, PopulationType type, BigDecimal latitude, BigDecimal longitude) {
        this.neighborhood = neighborhood;
        this.year = year;
        this.month = month;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal calculateAveragePopulation() {
        List<BigDecimal> populations = Arrays.asList(
                population00, population01, population02, population03,
                population04, population05, population06, population07,
                population08, population09, population10, population11,
                population12, population13, population14, population15,
                population16, population17, population18, population19,
                population20, population21, population22, population23
        );

        long nonNullCount = populations.stream()
                .filter(Objects::nonNull)
                .count();

        if (nonNullCount == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal sum = populations.stream()
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.divide(BigDecimal.valueOf(nonNullCount), 6, RoundingMode.HALF_UP);
    }
}