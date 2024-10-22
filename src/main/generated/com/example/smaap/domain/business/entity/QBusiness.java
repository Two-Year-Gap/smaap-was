package com.example.smaap.domain.business.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBusiness is a Querydsl query type for Business
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusiness extends EntityPathBase<Business> {

    private static final long serialVersionUID = -895931426L;

    public static final QBusiness business = new QBusiness("business");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<Store, QStore> stores = this.<Store, QStore>createList("stores", Store.class, QStore.class, PathInits.DIRECT2);

    public QBusiness(String variable) {
        super(Business.class, forVariable(variable));
    }

    public QBusiness(Path<? extends Business> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusiness(PathMetadata metadata) {
        super(Business.class, metadata);
    }

}

