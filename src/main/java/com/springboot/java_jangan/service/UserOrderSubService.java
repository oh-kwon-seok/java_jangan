package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import com.springboot.java_jangan.data.entity.UserProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderSubService {

    List<UserOrderSub> getTotalUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> getTotalUserOrderSubHistory(UserOrderSubSearchDto userOrderSubSearchDto);


    List<UserOrderSub> getTotalMobileUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> getTotalMobileBuyUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);


    List<UserOrderSub> getUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> getUserOrderSubPrice(UserOrderSubSearchDto userOrderSubSearchDto);




}
