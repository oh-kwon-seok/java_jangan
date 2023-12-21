package com.springboot.java_jangan.data.repository.UserTempOrder;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_jangan.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserTempOrderRepositoryCustomImpl extends QuerydslRepositorySupport implements UserTempOrderRepositoryCustom {

    public UserTempOrderRepositoryCustomImpl(){
        super(User.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);

    @Override
    public List<UserTempOrder> findAll(UserTempOrderSearchDto userTempOrderSearchDto){

        QUserTempOrder userTempOrder = QUserTempOrder.userTempOrder;

        QUser user = QUser.user;
        QCar car = QCar.car;

        String filter_title = userTempOrderSearchDto.getFilter_title();
        String search_text = userTempOrderSearchDto.getSearch_text();

        LocalDateTime start_date = userTempOrderSearchDto.getStart_date();
        LocalDateTime end_date = userTempOrderSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (userTempOrder.user != null) {
                builder.or(user.code.like("%" + search_text + "%"));
                builder.or(user.customer_name.like("%" + search_text + "%"));

            }
            if (userTempOrder.order_status != null) {
                builder.or(userTempOrder.order_status.like("%" + search_text + "%"));
            }

            if (userTempOrder.car != null) {
                builder.or(car.name.like("%" + search_text + "%"));
            }


        }else {
            if("code".equals(filter_title)){
                builder.and(user.code.like("%" + search_text + "%"));
            }
            else if("customer_name".equals(filter_title)){
                builder.and(user.customer_name.like("%" + search_text + "%"));
            }

            else if("order_status".equals(filter_title)){
                builder.and(userTempOrder.order_status.like("%" + search_text + "%"));
            }

            else if("car".equals(filter_title)){
                builder.and(car.name.like("%" + search_text + "%"));
            }

        }
        Predicate dateRange = userTempOrder.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = userTempOrder.used.eq(1);

        Predicate predicate = builder.getValue();





        List<Tuple> results = from(userTempOrder)
                .leftJoin(userTempOrder.car, car).fetchJoin()
                .leftJoin(userTempOrder.user, user).fetchJoin()
                .select(userTempOrder,user,car)
                .where(predicate,used,dateRange)
                .orderBy(userTempOrder.created.desc()) // Order by created field in descending order
                .fetch();


        List<UserTempOrder> userTempOrderList = new ArrayList<>();

        LOGGER.info("test5 : {}",userTempOrderList);

        for (Tuple result : results) {
            UserTempOrder userTempOrderEntity = result.get(userTempOrder);
            userTempOrderList.add(userTempOrderEntity);
        }
        return userTempOrderList;

    }





}
