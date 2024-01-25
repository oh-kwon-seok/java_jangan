package com.springboot.java_jangan.data.repository.History;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryRepositoryCustomImpl extends QuerydslRepositorySupport implements HistoryRepositoryCustom {

    public HistoryRepositoryCustomImpl(){
        super(User.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);



}
