package com.springboot.java_jangan.data.repository.UserOrderSub;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;
import com.springboot.java_jangan.controller.UserOrderSubController;
import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserOrderSubRepositoryCustomImpl extends QuerydslRepositorySupport implements UserOrderSubRepositoryCustom {

    public UserOrderSubRepositoryCustomImpl(){
        super(UserOrderSub.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserOrderSubController.class);


    @Override
    public List<UserOrderSub> findAll(UserOrderSubSearchDto userOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserOrder userOrder = QUserOrder.userOrder;


        QUserOrderSub userOrderSub = QUserOrderSub.userOrderSub;



        String filter_title = userOrderSubSearchDto.getFilter_title();
        String search_text = userOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userOrderSubSearchDto.getEnd_date();
        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));
                builder.or(product.type.like("%" + search_text + "%"));
            }
            if (userOrder.car != null) {
                builder.or(userOrder.car.name.like("%" + search_text + "%"));
            }
            if (userOrder.order_status != null) {
                builder.or(userOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.like("%" + search_text + "%"));
            }
            else if("car".equals(filter_title)){
                builder.and(userOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userOrderSub.created.between(start_date, end_date);

        Predicate predicate = builder.getValue();

        LOGGER.info("pre : {}",predicate);

        List<Tuple> results = from(userOrderSub)
                .leftJoin(userOrderSub.product, product).fetchJoin()
                .leftJoin(userOrderSub.userOrder, userOrder).fetchJoin()
                .select(userOrderSub,product,userOrder)
                .where(predicate,dateRange)
                .orderBy(product.company.name.desc(),userOrder.car.name.desc(),userOrderSub.created.desc())
                .fetch();

        List<UserOrderSub> userOrderSubList = new ArrayList<>();

        LOGGER.info("test5 : {}",userOrderSubList);
        for (Tuple result : results) {
            UserOrderSub userOrderSubEntity = result.get(userOrderSub);
            userOrderSubList.add(userOrderSubEntity);
        }
        return userOrderSubList;

    }


    @Override
    public List<UserOrderSub> findAllHistory(UserOrderSubSearchDto userOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserOrder userOrder = QUserOrder.userOrder;


        QUserOrderSub userOrderSub = QUserOrderSub.userOrderSub;



        String filter_title = userOrderSubSearchDto.getFilter_title();
        String search_text = userOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userOrderSubSearchDto.getEnd_date();
        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));
                builder.or(product.type.like("%" + search_text + "%"));
            }
            if (userOrder.car != null) {
                builder.or(userOrder.car.name.like("%" + search_text + "%"));
            }
            if (userOrder.order_status != null) {
                builder.or(userOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.like("%" + search_text + "%"));
            }
            else if("car".equals(filter_title)){
                builder.and(userOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userOrderSub.created.between(start_date, end_date);

        Predicate buy_filter = userOrderSub.buy_price.gt(0);




        Predicate predicate = builder.getValue();
        LOGGER.info("dateRange : {},{},{}",dateRange,buy_filter,predicate);
        LOGGER.info("pre : {}",predicate);
        LOGGER.info("buy11 : {}",userOrderSub.buy_price);

        List<Tuple> results = from(userOrderSub)
                .leftJoin(userOrderSub.product, product).fetchJoin()
                .leftJoin(userOrderSub.userOrder, userOrder).fetchJoin()
                .select(userOrderSub,product,userOrder)
                .where(dateRange,buy_filter,predicate)
                .orderBy(product.company.name.desc(),userOrder.car.name.desc(),userOrderSub.updated.desc())
                .fetch();



        List<UserOrderSub> userOrderSubList = new ArrayList<>();


        for (Tuple result : results) {
            UserOrderSub userOrderSubEntity = result.get(userOrderSub);



            userOrderSubList.add(userOrderSubEntity);
        }

        return userOrderSubList;

    }



    @Override
    public List<UserOrderSub> findMobileAll(UserOrderSubSearchDto userOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserOrder userOrder = QUserOrder.userOrder;


        QUserOrderSub userOrderSub = QUserOrderSub.userOrderSub;



        String filter_title = userOrderSubSearchDto.getFilter_title();
        String search_text = userOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userOrderSubSearchDto.getEnd_date();
        String user_id = userOrderSubSearchDto.getUser_id();

        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));
                builder.or(product.type.like("%" + search_text + "%"));
            }
            if (userOrder.car != null) {
                builder.or(userOrder.car.name.like("%" + search_text + "%"));
            }
            if (userOrder.order_status != null) {
                builder.or(userOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.like("%" + search_text + "%"));

            }
            else if("car".equals(filter_title)){
                builder.and(userOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userOrderSub.created.between(start_date, end_date);
        Predicate userId = userOrder.user.id.eq(user_id);


        Predicate predicate = builder.getValue();

        Predicate orderStatus = userOrder.order_status.ne("장바구니");

        LOGGER.info("pre : {}",predicate);

        List<Tuple> results = from(userOrderSub)
                .leftJoin(userOrderSub.product, product).fetchJoin()
                .leftJoin(userOrderSub.userOrder, userOrder).fetchJoin()
                .select(userOrderSub,product,userOrder)
                .where(predicate,dateRange,userId,orderStatus)
                .orderBy(
                        userOrderSub.created.desc(),  // 날짜 기준으로 내림차순 정렬
                        product.type.desc(),           // 타입 기준으로 내림차순 정렬
                        userOrderSub.created.asc()     // 추가적으로 날짜를 오름차순으로 정렬 (동일한 날짜의 경우)
                )
                .fetch();

        List<UserOrderSub> userOrderSubList = new ArrayList<>();

        LOGGER.info("test5 : {}",userOrderSubList);
        for (Tuple result : results) {
            UserOrderSub userOrderSubEntity = result.get(userOrderSub);
            userOrderSubList.add(userOrderSubEntity);
        }
        return userOrderSubList;

    }



    @Override
    public List<UserOrderSub> findMobileBuyAll(UserOrderSubSearchDto userOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserOrder userOrder = QUserOrder.userOrder;


        QUserOrderSub userOrderSub = QUserOrderSub.userOrderSub;



        String filter_title = userOrderSubSearchDto.getFilter_title();
        String search_text = userOrderSubSearchDto.getSearch_text();

        LocalDateTime start_date = userOrderSubSearchDto.getStart_date();
        LocalDateTime end_date = userOrderSubSearchDto.getEnd_date();
        String user_id = userOrderSubSearchDto.getUser_id();

        BooleanBuilder builder = new BooleanBuilder();

        if("all".equals(filter_title)){
            if (product.company != null) {
                builder.or(product.company.name.like("%" + search_text + "%"));
            }
            if (product.name != null) {
                builder.or(product.name.like("%" + search_text + "%"));
                builder.or(product.type.like("%" + search_text + "%"));
            }
            if (userOrder.car != null) {
                builder.or(userOrder.car.name.like("%" + search_text + "%"));
            }
            if (userOrder.order_status != null) {
                builder.or(userOrder.order_status.like("%" + search_text + "%"));
            }

        }else {
            if("company".equals(filter_title)){
                builder.and(product.company.name.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(product.type.like("%" + search_text + "%"));

            }
            else if("car".equals(filter_title)){
                builder.and(userOrder.car.name.like("%" + search_text + "%"));
            }
            else if("order_status".equals(filter_title)) {
                builder.and(userOrder.order_status.like("%" + search_text + "%"));
            }
        }

        Predicate dateRange = userOrderSub.created.between(start_date, end_date);
        Predicate userId = userOrder.user.id.eq(user_id);


        Predicate predicate = builder.getValue();

        LOGGER.info("pre : {}",predicate);

        List<Tuple> results = from(userOrderSub)
                .leftJoin(userOrderSub.product, product).fetchJoin()
                .leftJoin(userOrderSub.userOrder, userOrder).fetchJoin()
                .select(userOrderSub,product,userOrder,product.count().as("row_count"))
                .where(predicate,dateRange,userId)
                .groupBy(product)
                .orderBy(product.count().desc(),userOrderSub.created.desc(),product.name.desc())
                .fetch();

        List<UserOrderSub> userOrderSubList = new ArrayList<>();

        LOGGER.info("test5 : {}",userOrderSubList);
        for (Tuple result : results) {
            UserOrderSub userOrderSubEntity = result.get(userOrderSub);
            userOrderSubList.add(userOrderSubEntity);
        }
        return userOrderSubList;

    }


    @Override
    public List<UserOrderSub> findInfo(UserOrderSubSearchDto UserOrderSubSearchDto){

        QProduct product = QProduct.product;
        QUserOrder userOrder = QUserOrder.userOrder;


        QUserOrderSub userOrderSub = QUserOrderSub.userOrderSub;
        Long search_id = Long.valueOf(UserOrderSubSearchDto.getUser_order_uid());

        Predicate user_order_uid = userOrder.uid.eq(search_id);

        List<Tuple> results = from(userOrderSub)
                .leftJoin(userOrderSub.product, product).fetchJoin()
                .leftJoin(userOrderSub.userOrder, userOrder).fetchJoin()
                .select(userOrderSub,product,userOrder)
                .where(user_order_uid)
                .fetch();
        List<UserOrderSub> userOrderSubList = new ArrayList<>();
        for (Tuple result : results) {
            UserOrderSub userOrderSubEntity = result.get(userOrderSub);
            userOrderSubList.add(userOrderSubEntity);
        }
        return userOrderSubList;

    }



}
