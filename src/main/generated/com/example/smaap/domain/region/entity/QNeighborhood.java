package com.example.smaap.domain.region.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNeighborhood is a Querydsl query type for Neighborhood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNeighborhood extends EntityPathBase<Neighborhood> {

    private static final long serialVersionUID = 557442464L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNeighborhood neighborhood = new QNeighborhood("neighborhood");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    public final QDistrict district;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QNeighborhood(String variable) {
        this(Neighborhood.class, forVariable(variable), INITS);
    }

    public QNeighborhood(Path<? extends Neighborhood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNeighborhood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNeighborhood(PathMetadata metadata, PathInits inits) {
        this(Neighborhood.class, metadata, inits);
    }

    public QNeighborhood(Class<? extends Neighborhood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.district = inits.isInitialized("district") ? new QDistrict(forProperty("district"), inits.get("district")) : null;
    }

}

