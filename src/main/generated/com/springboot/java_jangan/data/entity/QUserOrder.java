package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserOrder is a Querydsl query type for UserOrder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserOrder extends EntityPathBase<UserOrder> {

    private static final long serialVersionUID = -1016533402L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserOrder userOrder = new QUserOrder("userOrder");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath amount_array = createString("amount_array");

    public final QCar car;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath image_url = createString("image_url");

    public final StringPath order_status = createString("order_status");

    public final StringPath price_status = createString("price_status");

    public final StringPath req_date = createString("req_date");

    public final StringPath req_des = createString("req_des");

    public final StringPath ship_image_url = createString("ship_image_url");

    public final NumberPath<java.math.BigDecimal> totalAmount = createNumber("totalAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> totalBuyPrice = createNumber("totalBuyPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> totalSupplyPrice = createNumber("totalSupplyPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> totalUnpaidPrice = createNumber("totalUnpaidPrice", java.math.BigDecimal.class);

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final NumberPath<Integer> used = createNumber("used", Integer.class);

    public final QUser user;

    public QUserOrder(String variable) {
        this(UserOrder.class, forVariable(variable), INITS);
    }

    public QUserOrder(Path<? extends UserOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserOrder(PathMetadata metadata, PathInits inits) {
        this(UserOrder.class, metadata, inits);
    }

    public QUserOrder(Class<? extends UserOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.car = inits.isInitialized("car") ? new QCar(forProperty("car")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

