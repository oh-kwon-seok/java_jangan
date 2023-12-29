package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.UserOrderDAO;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderResultDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserOrder;
import com.springboot.java_jangan.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    private final UserOrderDAO userOrderDAO;

    @Autowired
    public UserOrderServiceImpl(@Qualifier("userOrderDAOImpl") UserOrderDAO userOrderDAO){
        this.userOrderDAO = userOrderDAO;
    }


    @Override
    public List<UserOrder> getUserOrder(UserOrderSearchDto userOrderSearchDto){
        return userOrderDAO.selectUserOrder(userOrderSearchDto);
    }



    @Override
    public List<UserOrder> getTotalUserOrder(UserOrderSearchDto userOrderSearchDto){
        return userOrderDAO.selectTotalUserOrder(userOrderSearchDto);
    }

    @Override
    public UserOrderResultDto saveUserOrder(UserOrderDto userOrderDto) throws Exception {

        return userOrderDAO.insertUserOrder(userOrderDto);

    }
    @Override
    public UserOrderResultDto updateUserOrder(UserOrderDto userOrderDto) throws Exception {
        return userOrderDAO.updateUserOrder(userOrderDto);
    }
    @Override
    public void deleteUserOrder(List<Long> uid) throws Exception {
        userOrderDAO.deleteUserOrder(uid);
    }

}
