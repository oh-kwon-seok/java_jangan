package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.UserTempOrderDAO;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrder;
import com.springboot.java_jangan.service.UserTempOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTempOrderServiceImpl implements UserTempOrderService {
    private final UserTempOrderDAO UserTempOrderDAO;

    @Autowired
    public UserTempOrderServiceImpl(@Qualifier("userTempOrderDAOImpl") UserTempOrderDAO UserTempOrderDAO){
        this.UserTempOrderDAO = UserTempOrderDAO;
    }


    @Override
    public List<UserTempOrder> getTotalUserTempOrder(UserTempOrderSearchDto UserTempOrderSearchDto){
        return UserTempOrderDAO.selectTotalUserTempOrder(UserTempOrderSearchDto);
    }

    @Override
    public UserTempOrderResultDto saveUserTempOrder(UserTempOrderDto UserTempOrderDto) throws Exception {

        return UserTempOrderDAO.insertUserTempOrder(UserTempOrderDto);

    }


}
