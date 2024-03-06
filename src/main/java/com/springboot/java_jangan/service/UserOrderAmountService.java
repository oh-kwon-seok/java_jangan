package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;

import com.springboot.java_jangan.data.entity.UserOrderAmount;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderAmountService {

    List<UserOrderAmount> getUserOrderAmount(UserOrderAmountSearchDto userOrderSubSearchDto);

    
}

