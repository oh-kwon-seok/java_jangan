package com.springboot.java_jangan.service.impl;


import com.springboot.java_jangan.data.dao.UserOrderAmountDAO;
import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderAmount;
import com.springboot.java_jangan.service.UserOrderAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderAmountServiceImpl implements UserOrderAmountService {
    private final UserOrderAmountDAO userOrderAmountDAO;

    @Autowired
    public UserOrderAmountServiceImpl(@Qualifier("userOrderAmountDAOImpl") UserOrderAmountDAO userOrderAmountDAO){
        this.userOrderAmountDAO = userOrderAmountDAO;
    }

    @Override
    public List<UserOrderAmount> getUserOrderAmount(UserOrderAmountSearchDto userOrderAmountSearchDto){
        return userOrderAmountDAO.selectUserOrderAmount(userOrderAmountSearchDto);
    }

   


}
