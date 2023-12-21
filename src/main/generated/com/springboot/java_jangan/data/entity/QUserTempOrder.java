package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserTempOrder is a Querydsl query type for UserTempOrder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserTempOrder extends EntityPathBase<UserTempOrder> {

    private static final long serialVersionUID = 2062267122L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserTempOrder userTempOrder = new QUserTempOrder("userTempOrder");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCar car;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final StringPath order_status = createString("order_status");

    public final NumberPath<java.math.BigDecimal> totalBuyPrice = createNumber("totalBuyPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> totalSupplyPrice = createNumber("totalSupplyPrice", java.math.BigDecimal.class);

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final NumberPath<Integer> used = createNumber("used", Integer.class);

    public final QUser user;

    public QUserTempOrder(String variable) {
        this(UserTempOrder.class, forVariable(variable), INITS);
    }

    public QUserTempOrder(Path<? extends UserTempOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserTempOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserTempOrder(PathMetadata metadata, PathInits inits) {
        this(UserTempOrder.class, metadata, inits);
    }

    public QUserTempOrder(Class<? extends UserTempOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.car = inits.isInitialized("car") ? new QCar(forProperty("car")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

