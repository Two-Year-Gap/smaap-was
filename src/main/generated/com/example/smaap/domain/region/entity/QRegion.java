package com.example.smaap.domain.region.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegion is a Querydsl query type for Region
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegion extends EntityPathBase<Region> {

    private static final long serialVersionUID = -1005913338L;

    public static final QRegion region = new QRegion("region");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    public final ListPath<District, QDistrict> districts = this.<District, QDistrict>createList("districts", District.class, QDistrict.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QRegion(String variable) {
        super(Region.class, forVariable(variable));
    }

    public QRegion(Path<? extends Region> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegion(PathMetadata metadata) {
        super(Region.class, metadata);
    }

}

