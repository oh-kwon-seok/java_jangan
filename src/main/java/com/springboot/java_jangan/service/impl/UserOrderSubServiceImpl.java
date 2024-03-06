package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.UserOrderSubDAO;
import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import com.springboot.java_jangan.service.UserOrderSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderSubServiceImpl implements UserOrderSubService {
    private final UserOrderSubDAO userOrderSubDAO;

    @Autowired
    public UserOrderSubServiceImpl(@Qualifier("userOrderSubDAOImpl") UserOrderSubDAO userOrderSubDAO){
        this.userOrderSubDAO = userOrderSubDAO;
    }

    @Override
    public List<UserOrderSub> getTotalUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto){
        return userOrderSubDAO.selectTotalUserOrderSub(userOrderSubSearchDto);
    }

    @Override
    public List<UserOrderSub> getTotalUserOrderSubHistory(UserOrderSubSearchDto userOrderSubSearchDto){
        return userOrderSubDAO.selectTotalUserOrderSubHistory(userOrderSubSearchDto);
    }
    @Override
    public List<UserOrderSub> getTotalMobileUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto){
        return userOrderSubDAO.selectTotalMobileUserOrderSub(userOrderSubSearchDto);
    }

    @Override
    public List<UserOrderSub> getTotalMobileBuyUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto){
        return userOrderSubDAO.selectTotalMobileBuyUserOrderSub(userOrderSubSearchDto);
    }


    @Override
    public List<UserOrderSub> getUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto){
        return userOrderSubDAO.selectUserOrderSub(userOrderSubSearchDto);
    }

    @Override
    public List<UserOrderSub> getUserOrderSubPrice(UserOrderSubSearchDto userOrderSubSearchDto){
        return userOrderSubDAO.selectUserOrderSubPrice(userOrderSubSearchDto);
    }


}
