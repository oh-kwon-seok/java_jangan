package com.springboot.java_jangan.data.repository.UserOrder;

import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.entity.UserOrder;

import java.util.List;

public interface UserOrderRepositoryCustom {


    List<UserOrder> findAllByDashboard(UserOrderSearchDto userOrderSearchDto);
    List<UserOrder> findAll(UserOrderSearchDto userOrderSearchDto);


}
