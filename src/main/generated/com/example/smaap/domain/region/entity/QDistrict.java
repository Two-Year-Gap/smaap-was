package com.example.smaap.domain.region.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDistrict is a Querydsl query type for District
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDistrict extends EntityPathBase<District> {

    private static final long serialVersionUID = 664226592L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDistrict district = new QDistrict("district");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<Neighborhood, QNeighborhood> neighborhoods = this.<Neighborhood, QNeighborhood>createList("neighborhoods", Neighborhood.class, QNeighborhood.class, PathInits.DIRECT2);

    public final QRegion region;

    public QDistrict(String variable) {
        this(District.class, forVariable(variable), INITS);
    }

    public QDistrict(Path<? extends District> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDistrict(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDistrict(PathMetadata metadata, PathInits inits) {
        this(District.class, metadata, inits);
    }

    public QDistrict(Class<? extends District> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

