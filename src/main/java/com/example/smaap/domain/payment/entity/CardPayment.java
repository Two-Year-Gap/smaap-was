package com.example.smaap.domain.payment.entity;

import com.example.smaap.common.entity.BaseEntity;
import com.example.smaap.domain.business.entity.Business;
import com.example.smaap.domain.region.entity.Neighborhood;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CardPayment extends BaseEntity {
    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    @Column(name = "month", nullable = false, length = 2)
    private Integer month;

    @ManyToOne
    @JoinColumn(name = "neighborhood_id", nullable = false)
    private Neighborhood neighborhood;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(name = "total_amount", nullable = false)
    private Long totalAmount;

    @Column(name = "total_usage", nullable = false)
    private Integer totalUsage;

    @Builder
    public CardPayment(Integer year, Integer month, Neighborhood neighborhood, Business business, Long totalAmount, Integer totalUsage) {
        this.year = year;
        this.month = month;
        this.neighborhood = neighborhood;
        this.business = business;
        this.totalAmount = totalAmount;
        this.totalUsage = totalUsage;
    }
}
