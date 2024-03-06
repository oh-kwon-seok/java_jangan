package com.springboot.java_jangan.data.repository.UserTempOrderSub;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.UserTempOrderSubController;
import com.springboot.java_jangan.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.QProduct;
import com.springboot.java_jangan.data.entity.QUserTempOrder;
import com.springboot.java_jangan.data.entity.QUserTempOrderSub;
import com.springboot.java_jangan.data.entity.UserTempOrderSub;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserTempOrderSubRepositoryCustomImpl extends QuerydslRepositorySupport implements UserTempOrderSubRepositoryCustom {

    public UserTempOrderSubRepositoryCustomImpl(){
        super(UserTempOrderSub.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserTempOrderSubController.class);


    @Override
    public List<UserTempOrderSub> findAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserTempOrder userTempOrder = QUserTempOrder.userTempOrder;


        QUserTempOrderSub userTempOrderSub = QUserTempOrderSub.userTempOrderSub;



        String filter_title = userTempOrderSubSearchDto.getFilter_title();
        String search_text = userTempOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userTempOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userTempOrderSubSearchDto.getEnd_date();
        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));

            }
            if (product.type != null) {
                builder.or(product.type.name.like("%" + search_text + "%"));
            }
            if (userTempOrder.car != null) {
                builder.or(userTempOrder.car.name.like("%" + search_text + "%"));
            }
            if (userTempOrder.order_status != null) {
                builder.or(userTempOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.name.like("%" + search_text + "%"));
            }
            else if("car".equals(filter_title)){
                builder.and(userTempOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userTempOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userTempOrderSub.created.between(start_date, end_date);

        Predicate predicate = builder.getValue();

        LOGGER.info("pre : {}",predicate);

        List<Tuple> results = from(userTempOrderSub)
                .leftJoin(userTempOrderSub.product, product).fetchJoin()
                .leftJoin(userTempOrderSub.userTempOrder, userTempOrder).fetchJoin()
                .select(userTempOrderSub,product,userTempOrder)
                .where(predicate,dateRange)
                .orderBy(product.company.name.desc(),userTempOrder.car.name.desc(),userTempOrderSub.created.desc())
                .fetch();

        List<UserTempOrderSub> userTempOrderSubList = new ArrayList<>();

        LOGGER.info("test5 : {}",userTempOrderSubList);
        for (Tuple result : results) {
            UserTempOrderSub userTempOrderSubEntity = result.get(userTempOrderSub);
            userTempOrderSubList.add(userTempOrderSubEntity);
        }
        return userTempOrderSubList;

    }



    @Override
    public List<UserTempOrderSub> findMobileAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserTempOrder userTempOrder = QUserTempOrder.userTempOrder;


        QUserTempOrderSub userTempOrderSub = QUserTempOrderSub.userTempOrderSub;



        String filter_title = userTempOrderSubSearchDto.getFilter_title();
        String search_text = userTempOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userTempOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userTempOrderSubSearchDto.getEnd_date();
        String user_id = userTempOrderSubSearchDto.getUser_id();

        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));

            }
            if (product.type != null) {
                builder.or(product.type.name.like("%" + search_text + "%"));

            }
            if (userTempOrder.car != null) {
                builder.or(userTempOrder.car.name.like("%" + search_text + "%"));
            }
            if (userTempOrder.order_status != null) {
                builder.or(userTempOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.name.like("%" + search_text + "%"));

            }
            else if("car".equals(filter_title)){
                builder.and(userTempOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userTempOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userTempOrderSub.created.between(start_date, end_date);
        Predicate userId = userTempOrder.user.id.eq(user_id);


        Predicate predicate = builder.getValue();

        LOGGER.info("pre : {}",predicate);

        List<Tuple> results = from(userTempOrderSub)
                .leftJoin(userTempOrderSub.product, product).fetchJoin()
                .leftJoin(userTempOrderSub.userTempOrder, userTempOrder).fetchJoin()
                .select(userTempOrderSub,product,userTempOrder)
                .where(predicate,dateRange,userId)
                .orderBy(userTempOrderSub.created.desc(),product.name.desc())
                .fetch();

        List<UserTempOrderSub> userTempOrderSubList = new ArrayList<>();

        LOGGER.info("test5 : {}",userTempOrderSubList);
        for (Tuple result : results) {
            UserTempOrderSub userTempOrderSubEntity = result.get(userTempOrderSub);
            userTempOrderSubList.add(userTempOrderSubEntity);
        }
        return userTempOrderSubList;

    }



    @Override
    public List<UserTempOrderSub> findMobileBuyAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserTempOrder userTempOrder = QUserTempOrder.userTempOrder;


        QUserTempOrderSub userTempOrderSub = QUserTempOrderSub.userTempOrderSub;



        String filter_title = userTempOrderSubSearchDto.getFilter_title();
        String search_text = userTempOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userTempOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userTempOrderSubSearchDto.getEnd_date();
        String user_id = userTempOrderSubSearchDto.getUser_id();

        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));

            }
            if (product.type != null) {
                builder.or(product.type.name.like("%" + search_text + "%"));
            }
            if (userTempOrder.car != null) {
                builder.or(userTempOrder.car.name.like("%" + search_text + "%"));
            }
            if (userTempOrder.order_status != null) {
                builder.or(userTempOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.name.like("%" + search_text + "%"));

            }
            else if("car".equals(filter_title)){
                builder.and(userTempOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userTempOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userTempOrderSub.created.between(start_date, end_date);
        Predicate userId = userTempOrder.user.id.eq(user_id);


        Predicate predicate = builder.getValue();

        LOGGER.info("pre : {}",predicate);

        List<Tuple> results = from(userTempOrderSub)
                .leftJoin(userTempOrderSub.product, product).fetchJoin()
                .leftJoin(userTempOrderSub.userTempOrder, userTempOrder).fetchJoin()

                .select(userTempOrderSub,product,userTempOrder,product.count().as("row_count"))
                .where(predicate,dateRange,userId)
                .groupBy(product)
                .orderBy(product.count().desc(),userTempOrderSub.created.desc(),product.name.desc())
                .fetch();

        List<UserTempOrderSub> userTempOrderSubList = new ArrayList<>();

        LOGGER.info("test5 : {}",userTempOrderSubList);
        for (Tuple result : results) {
            UserTempOrderSub userTempOrderSubEntity = result.get(userTempOrderSub);
            userTempOrderSubList.add(userTempOrderSubEntity);
        }
        return userTempOrderSubList;

    }


    @Override
    public List<UserTempOrderSub> findInfo(UserTempOrderSubSearchDto UserTempOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserTempOrder userTempOrder = QUserTempOrder.userTempOrder;


        QUserTempOrderSub userTempOrderSub = QUserTempOrderSub.userTempOrderSub;
        Long search_id = Long.valueOf(UserTempOrderSubSearchDto.getUser_order_uid());

        Predicate user_order_uid = userTempOrder.uid.eq(search_id);

        List<Tuple> results = from(userTempOrderSub)
                .leftJoin(userTempOrderSub.product, product).fetchJoin()
                .leftJoin(userTempOrderSub.userTempOrder, userTempOrder).fetchJoin()
                .select(userTempOrderSub,product,userTempOrder)
                .where(user_order_uid)
                .fetch();
        List<UserTempOrderSub> userTempOrderSubList = new ArrayList<>();
        for (Tuple result : results) {
            UserTempOrderSub userTempOrderSubEntity = result.get(userTempOrderSub);
            userTempOrderSubList.add(userTempOrderSubEntity);
        }
        return userTempOrderSubList;

    }



}
