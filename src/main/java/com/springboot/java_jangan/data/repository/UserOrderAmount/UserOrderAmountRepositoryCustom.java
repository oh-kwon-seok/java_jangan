package com.springboot.java_jangan.data.repository.UserOrderAmount;


import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;
import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderAmount;
import com.springboot.java_jangan.data.entity.UserOrderSub;

import java.util.List;

public interface UserOrderAmountRepositoryCustom {


    List<UserOrderAmount> findAll(UserOrderAmountSearchDto userOrderAmountSearchDto);


}
