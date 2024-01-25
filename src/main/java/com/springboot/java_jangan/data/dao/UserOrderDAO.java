package com.springboot.java_jangan.data.dao;

import com.springboot.java_jangan.data.dto.userOrder.UserOrderDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderResultDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserOrder;

import java.util.List;


public interface UserOrderDAO {


    List<UserOrder> selectUserOrder(UserOrderSearchDto userOrderSearchDto);
    List<UserOrder> selectTotalUserOrder(UserOrderSearchDto userOrderSearchDto);


     UserOrderResultDto insertUserOrder(UserOrderDto userOrderDto)  throws Exception;

    UserOrderResultDto updateUserOrder(UserOrderDto userOrderDto) throws Exception;

    List<UserOrder> selectMobileTempTotalUserOrder(UserOrderSearchDto userOrderSearchDto);

    String deleteUserOrder(List<Long> uid) throws Exception;


}
