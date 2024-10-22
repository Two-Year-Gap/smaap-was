package com.example.smaap.domain.welfare.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWelfareInfra is a Querydsl query type for WelfareInfra
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWelfareInfra extends EntityPathBase<WelfareInfra> {

    private static final long serialVersionUID = 1215708268L;

    public static final QWelfareInfra welfareInfra = new QWelfareInfra("welfareInfra");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigDecimal> latitude = createNumber("latitude", java.math.BigDecimal.class);

    public final StringPath locationExplanation = createString("locationExplanation");

    public final NumberPath<java.math.BigDecimal> longitude = createNumber("longitude", java.math.BigDecimal.class);

    public final StringPath lotNumberAddress = createString("lotNumberAddress");

    public final StringPath name = createString("name");

    public final StringPath readNameAddress = createString("readNameAddress");

    public final EnumPath<com.example.smaap.domain.welfare.type.WelfareInfraType> type = createEnum("type", com.example.smaap.domain.welfare.type.WelfareInfraType.class);

    public QWelfareInfra(String variable) {
        super(WelfareInfra.class, forVariable(variable));
    }

    public QWelfareInfra(Path<? extends WelfareInfra> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWelfareInfra(PathMetadata metadata) {
        super(WelfareInfra.class, metadata);
    }

}

