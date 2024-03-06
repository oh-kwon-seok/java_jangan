package com.springboot.java_jangan.data.repository.UserOrderAmount;



import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.NumberExpression;
import com.springboot.java_jangan.controller.UserOrderAmountController;
import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;
import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;
import com.springboot.java_jangan.data.entity.*;

import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.Logger;


@Component
public class UserOrderAmountRepositoryCustomImpl extends QuerydslRepositorySupport implements UserOrderAmountRepositoryCustom {

    public UserOrderAmountRepositoryCustomImpl(){
        super(UserOrderAmount.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserOrderAmountController.class);


    @Override
    public List<UserOrderAmount> findAll(UserOrderAmountSearchDto userOrderAmountSearchDto){




        QUserOrderAmount userOrderAmount = QUserOrderAmount.userOrderAmount;
        QUserOrder userOrder = QUserOrder.userOrder;


        String end_date = userOrderAmountSearchDto.getEnd_date();
        String user_id = userOrderAmountSearchDto.getUser_id();
        BooleanBuilder builder = new BooleanBuilder();



        Predicate userId = userOrderAmount.user.id.eq(user_id);


        Predicate dateRange = userOrderAmount.amount_date.loe(end_date);


        Predicate predicate = builder.getValue();

        LOGGER.info("날짜 : {}",dateRange);
        LOGGER.info("userId : {}",userId);
        LOGGER.info("end_date : {}",end_date);


        NumberExpression<Integer> totalAmount = userOrderAmount.amount.sum().as("totalAmount");



        List<Tuple> results = from(userOrderAmount)
                .leftJoin(userOrderAmount.userOrder, userOrder).fetchJoin()
                .select(
                        userOrderAmount,
                        userOrderAmount.amount.sum().as("totalTest")

                         // amount를 합산하여 totalAmount로 별칭 지정

                )
                .groupBy(userOrderAmount) // 이 부분이 추가되었습니다.
                .where(predicate,userId,dateRange)
                .fetch();

        List<UserOrderAmount> userOrderAmountList = new ArrayList<>();

        LOGGER.info("test1 : {}",userOrderAmountList);
        for (Tuple result : results) {
            UserOrderAmount userOrderAmountEntity = result.get(userOrderAmount);
            userOrderAmountList.add(userOrderAmountEntity);
        }
        return userOrderAmountList;

    }



}
