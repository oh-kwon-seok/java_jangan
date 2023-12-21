package com.springboot.java_jangan.data.dao;

import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrder;

import java.util.List;


public interface UserTempOrderDAO {


    List<UserTempOrder> selectTotalUserTempOrder(UserTempOrderSearchDto userTempOrderSearchDto);

     UserTempOrderResultDto insertUserTempOrder(UserTempOrderDto userTempOrderDto)  throws Exception;



}
