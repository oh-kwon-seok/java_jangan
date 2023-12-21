package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserTempOrderService {

    List<UserTempOrder> getTotalUserTempOrder(UserTempOrderSearchDto UserTempOrderSearchDto);


    UserTempOrderResultDto saveUserTempOrder(UserTempOrderDto UserTempOrderDto) throws Exception;



}
