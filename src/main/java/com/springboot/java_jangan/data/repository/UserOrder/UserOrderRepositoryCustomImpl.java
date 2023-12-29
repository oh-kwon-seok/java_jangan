package com.springboot.java_jangan.data.repository.UserOrder;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserOrderRepositoryCustomImpl extends QuerydslRepositorySupport implements UserOrderRepositoryCustom {

    public UserOrderRepositoryCustomImpl(){
        super(User.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);





    @Override
    public List<UserOrder> findAllByDashboard(UserOrderSearchDto userOrderSearchDto){
        QUserOrder userOrder = QUserOrder.userOrder;

        QUser user = QUser.user;
        QCar car = QCar.car;




        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = userOrder.used.eq(1);



        List<Tuple> results = from(userOrder)
                .leftJoin(userOrder.car, car).fetchJoin()
                .leftJoin(userOrder.user, user).fetchJoin()


                .select(userOrder,user,car)
                .where(used)
                .orderBy(userOrder.created.desc()) // Order by created field in descending order
                .fetch();


        List<UserOrder> userOrderList = new ArrayList<>();

        for (Tuple result : results) {
            UserOrder userOrderEntity = result.get(userOrder);
            userOrderList.add(userOrderEntity);
        }
        return userOrderList;

    }


    @Override
    public List<UserOrder> findAll(UserOrderSearchDto userOrderSearchDto){
        QUserOrder userOrder = QUserOrder.userOrder;

        QUser user = QUser.user;
        QCar car = QCar.car;



        String filter_title = userOrderSearchDto.getFilter_title();
        String search_text = userOrderSearchDto.getSearch_text();

        LocalDateTime start_date = userOrderSearchDto.getStart_date();
        LocalDateTime end_date = userOrderSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (userOrder.user != null) {
                builder.or(user.code.like("%" + search_text + "%"));
                builder.or(user.customer_name.like("%" + search_text + "%"));

            }
            if (userOrder.order_status != null) {
                builder.or(userOrder.order_status.like("%" + search_text + "%"));
            }
            if (userOrder.price_status != null) {
                builder.or(userOrder.price_status.like("%" + search_text + "%"));
            }

            if (userOrder.car != null) {
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
                builder.and(userOrder.order_status.like("%" + search_text + "%"));
            }
            else if("price_status".equals(filter_title)){
                builder.and(userOrder.price_status.like("%" + search_text + "%"));
            }
            else if("car".equals(filter_title)){
                builder.and(car.name.like("%" + search_text + "%"));
            }

        }
        Predicate dateRange = userOrder.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = userOrder.used.eq(1);

        Predicate predicate = builder.getValue();





        List<Tuple> results = from(userOrder)
                .leftJoin(userOrder.car, car).fetchJoin()
                .leftJoin(userOrder.user, user).fetchJoin()


                .select(userOrder,user,car)
                .where(predicate,used,dateRange)
                .orderBy(userOrder.created.desc()) // Order by created field in descending order
                .fetch();


        List<UserOrder> userOrderList = new ArrayList<>();

        for (Tuple result : results) {
            UserOrder userOrderEntity = result.get(userOrder);
            userOrderList.add(userOrderEntity);
        }
        return userOrderList;

    }





}
