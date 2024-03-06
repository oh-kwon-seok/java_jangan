package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;

import com.springboot.java_jangan.data.entity.UserOrder;
import com.springboot.java_jangan.data.entity.UserOrderSub;

import java.util.List;


public interface UserOrderSubDAO {


    List<UserOrderSub> selectTotalUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectTotalUserOrderSubHistory(UserOrderSubSearchDto userOrderSubSearchDto);


    List<UserOrderSub> selectTotalMobileUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectTotalMobileBuyUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectUserOrderSubPrice(UserOrderSubSearchDto userOrderSubSearchDto);



}
