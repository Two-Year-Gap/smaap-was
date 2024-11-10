package com.example.smaap.domain.population.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPopulation is a Querydsl query type for Population
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPopulation extends EntityPathBase<Population> {

    private static final long serialVersionUID = 1467551224L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPopulation population = new QPopulation("population");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigDecimal> latitude = createNumber("latitude", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> longitude = createNumber("longitude", java.math.BigDecimal.class);

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final com.example.smaap.domain.region.entity.QNeighborhood neighborhood;

    public final NumberPath<java.math.BigDecimal> population00 = createNumber("population00", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population01 = createNumber("population01", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population02 = createNumber("population02", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population03 = createNumber("population03", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population04 = createNumber("population04", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population05 = createNumber("population05", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population06 = createNumber("population06", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population07 = createNumber("population07", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population08 = createNumber("population08", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population09 = createNumber("population09", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population10 = createNumber("population10", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population11 = createNumber("population11", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population12 = createNumber("population12", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population13 = createNumber("population13", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population14 = createNumber("population14", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population15 = createNumber("population15", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population16 = createNumber("population16", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population17 = createNumber("population17", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population18 = createNumber("population18", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population19 = createNumber("population19", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population20 = createNumber("population20", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population21 = createNumber("population21", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population22 = createNumber("population22", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> population23 = createNumber("population23", java.math.BigDecimal.class);

    public final EnumPath<com.example.smaap.domain.population.type.PopulationType> type = createEnum("type", com.example.smaap.domain.population.type.PopulationType.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QPopulation(String variable) {
        this(Population.class, forVariable(variable), INITS);
    }

    public QPopulation(Path<? extends Population> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPopulation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPopulation(PathMetadata metadata, PathInits inits) {
        this(Population.class, metadata, inits);
    }

    public QPopulation(Class<? extends Population> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.neighborhood = inits.isInitialized("neighborhood") ? new com.example.smaap.domain.region.entity.QNeighborhood(forProperty("neighborhood"), inits.get("neighborhood")) : null;
    }

}

