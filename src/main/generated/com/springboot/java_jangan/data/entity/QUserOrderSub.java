package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserOrderSub is a Querydsl query type for UserOrderSub
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserOrderSub extends EntityPathBase<UserOrderSub> {

    private static final long serialVersionUID = 267908602L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserOrderSub userOrderSub = new QUserOrderSub("userOrderSub");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> buy_price = createNumber("buy_price", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final QProduct product;

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public final NumberPath<Integer> supply_price = createNumber("supply_price", Integer.class);

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final QUserOrder userOrder;

    public QUserOrderSub(String variable) {
        this(UserOrderSub.class, forVariable(variable), INITS);
    }

    public QUserOrderSub(Path<? extends UserOrderSub> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserOrderSub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserOrderSub(PathMetadata metadata, PathInits inits) {
        this(UserOrderSub.class, metadata, inits);
    }

    public QUserOrderSub(Class<? extends UserOrderSub> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.userOrder = inits.isInitialized("userOrder") ? new QUserOrder(forProperty("userOrder"), inits.get("userOrder")) : null;
    }

}

