package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserProduct is a Querydsl query type for UserProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserProduct extends EntityPathBase<UserProduct> {

    private static final long serialVersionUID = -1033384441L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserProduct userProduct = new QUserProduct("userProduct");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final QProduct product;

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final NumberPath<Integer> used = createNumber("used", Integer.class);

    public final QUser user;

    public QUserProduct(String variable) {
        this(UserProduct.class, forVariable(variable), INITS);
    }

    public QUserProduct(Path<? extends UserProduct> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserProduct(PathMetadata metadata, PathInits inits) {
        this(UserProduct.class, metadata, inits);
    }

    public QUserProduct(Class<? extends UserProduct> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

