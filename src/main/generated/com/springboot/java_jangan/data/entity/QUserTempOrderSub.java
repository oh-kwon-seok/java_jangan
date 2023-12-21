package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserTempOrderSub is a Querydsl query type for UserTempOrderSub
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserTempOrderSub extends EntityPathBase<UserTempOrderSub> {

    private static final long serialVersionUID = 1787713006L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserTempOrderSub userTempOrderSub = new QUserTempOrderSub("userTempOrderSub");

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

    public final QUserTempOrder userTempOrder;

    public QUserTempOrderSub(String variable) {
        this(UserTempOrderSub.class, forVariable(variable), INITS);
    }

    public QUserTempOrderSub(Path<? extends UserTempOrderSub> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserTempOrderSub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserTempOrderSub(PathMetadata metadata, PathInits inits) {
        this(UserTempOrderSub.class, metadata, inits);
    }

    public QUserTempOrderSub(Class<? extends UserTempOrderSub> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.userTempOrder = inits.isInitialized("userTempOrder") ? new QUserTempOrder(forProperty("userTempOrder"), inits.get("userTempOrder")) : null;
    }

}

