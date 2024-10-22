package com.example.smaap.domain.school.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSchool is a Querydsl query type for School
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchool extends EntityPathBase<School> {

    private static final long serialVersionUID = 113738758L;

    public static final QSchool school = new QSchool("school");

    public final com.example.smaap.common.entity.QBaseEntity _super = new com.example.smaap.common.entity.QBaseEntity(this);

    public final NumberPath<Long> employeeCount = createNumber("employeeCount", Long.class);

    public final EnumPath<com.example.smaap.domain.school.type.SchoolGenderType> gender = createEnum("gender", com.example.smaap.domain.school.type.SchoolGenderType.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigDecimal> latitude = createNumber("latitude", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> longitude = createNumber("longitude", java.math.BigDecimal.class);

    public final StringPath lotNumberAddress = createString("lotNumberAddress");

    public final StringPath lotNumberZipCode = createString("lotNumberZipCode");

    public final StringPath name = createString("name");

    public final StringPath readNameAddress = createString("readNameAddress");

    public final StringPath readNameZipCode = createString("readNameZipCode");

    public final NumberPath<Long> studentCount = createNumber("studentCount", Long.class);

    public final EnumPath<com.example.smaap.domain.school.type.SchoolType> type = createEnum("type", com.example.smaap.domain.school.type.SchoolType.class);

    public QSchool(String variable) {
        super(School.class, forVariable(variable));
    }

    public QSchool(Path<? extends School> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchool(PathMetadata metadata) {
        super(School.class, metadata);
    }

}

