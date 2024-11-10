package com.example.smaap.domain.payment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCardPayment is a Querydsl query type for CardPayment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCardPayment extends EntityPathBase<CardPayment> {

    private static final long serialVersionUID = -491095980L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCardPayment cardPayment = new QCardPayment("cardPayment");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    public final com.example.smaap.domain.business.entity.QBusiness business;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final com.example.smaap.domain.region.entity.QNeighborhood neighborhood;

    public final NumberPath<Integer> totalAmount = createNumber("totalAmount", Integer.class);

    public final NumberPath<Integer> totalUsage = createNumber("totalUsage", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QCardPayment(String variable) {
        this(CardPayment.class, forVariable(variable), INITS);
    }

    public QCardPayment(Path<? extends CardPayment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCardPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCardPayment(PathMetadata metadata, PathInits inits) {
        this(CardPayment.class, metadata, inits);
    }

    public QCardPayment(Class<? extends CardPayment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.business = inits.isInitialized("business") ? new com.example.smaap.domain.business.entity.QBusiness(forProperty("business")) : null;
        this.neighborhood = inits.isInitialized("neighborhood") ? new com.example.smaap.domain.region.entity.QNeighborhood(forProperty("neighborhood"), inits.get("neighborhood")) : null;
    }

}

