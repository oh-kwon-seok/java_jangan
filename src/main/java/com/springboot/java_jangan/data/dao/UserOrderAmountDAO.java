package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;

import com.springboot.java_jangan.data.entity.UserOrderAmount;

import java.util.List;


public interface UserOrderAmountDAO {


    List<UserOrderAmount> selectUserOrderAmount(UserOrderAmountSearchDto userOrderAmountSearchDto);




}
