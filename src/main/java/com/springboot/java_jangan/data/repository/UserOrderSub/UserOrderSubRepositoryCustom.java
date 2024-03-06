package com.springboot.java_jangan.data.repository.UserOrderSub;

import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import com.springboot.java_jangan.data.entity.UserProduct;

import java.util.List;

public interface UserOrderSubRepositoryCustom {



    List<UserOrderSub> findAll(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findAllHistory(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findMobileAll(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findMobileBuyAll(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findInfo(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findSupplyPrice(UserOrderSubSearchDto userOrderSubSearchDto);

}
