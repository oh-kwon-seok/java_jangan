package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserOrderAmount is a Querydsl query type for UserOrderAmount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserOrderAmount extends EntityPathBase<UserOrderAmount> {

    private static final long serialVersionUID = 693716574L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserOrderAmount userOrderAmount = new QUserOrderAmount("userOrderAmount");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final StringPath amount_date = createString("amount_date");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final QUser user;

    public final QUserOrder userOrder;

    public QUserOrderAmount(String variable) {
        this(UserOrderAmount.class, forVariable(variable), INITS);
    }

    public QUserOrderAmount(Path<? extends UserOrderAmount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserOrderAmount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserOrderAmount(PathMetadata metadata, PathInits inits) {
        this(UserOrderAmount.class, metadata, inits);
    }

    public QUserOrderAmount(Class<? extends UserOrderAmount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
        this.userOrder = inits.isInitialized("userOrder") ? new QUserOrder(forProperty("userOrder"), inits.get("userOrder")) : null;
    }

}

