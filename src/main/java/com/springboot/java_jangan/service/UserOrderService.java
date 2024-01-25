package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.userOrder.UserOrderDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderResultDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderService {


    List<UserOrder> getUserOrder(UserOrderSearchDto userOrderSearchDto);

    List<UserOrder> getTotalUserOrder(UserOrderSearchDto userOrderSearchDto);

    List<UserOrder> getMobileTempTotalUserOrder(UserOrderSearchDto userOrderSearchDto);


    UserOrderResultDto saveUserOrder(UserOrderDto userOrderDto) throws Exception;

    UserOrderResultDto updateUserOrder(UserOrderDto userOrderDto) throws Exception;

    void deleteUserOrder(List<Long> uid) throws Exception;


}
