package com.springboot.java_jangan.data.repository.UserProduct;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserProductRepositoryCustomImpl extends QuerydslRepositorySupport implements UserProductRepositoryCustom {

    public UserProductRepositoryCustomImpl(){
        super(UserProduct.class);
    }


    @Override
    public List<UserProduct> findInfo(UserProductSearchDto UserProductSearchDto){

        QProduct product = QProduct.product;
        QUser user = QUser.user;


        QUserProduct userProduct = QUserProduct.userProduct;
        String search_id = UserProductSearchDto.getUser_id();

        Predicate used = userProduct.used.eq(1);
        Predicate user_id = user.id.eq(search_id);



        List<Tuple> results = from(userProduct)
                .leftJoin(userProduct.product, product).fetchJoin()
                .select(userProduct,product)
                .where(used,user_id)
                .fetch();
        List<UserProduct> userProductList = new ArrayList<>();
        for (Tuple result : results) {
            UserProduct userProductEntity = result.get(userProduct);
            userProductList.add(userProductEntity);
        }
        return userProductList;

    }



}
