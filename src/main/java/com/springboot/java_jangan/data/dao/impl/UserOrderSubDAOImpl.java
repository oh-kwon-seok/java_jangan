package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.UserOrderSubDAO;
import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import com.springboot.java_jangan.data.repository.UserOrderSub.UserOrderSubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserOrderSubDAOImpl implements UserOrderSubDAO {
    
    private final UserOrderSubRepository userOrderSubRepository;
    @Autowired
    public UserOrderSubDAOImpl(UserOrderSubRepository userOrderSubRepository){
        this.userOrderSubRepository = userOrderSubRepository;

    }

    @Override
    public List<UserOrderSub> selectTotalUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto) {
        return userOrderSubRepository.findAll(userOrderSubSearchDto);

    }

    @Override
    public List<UserOrderSub> selectTotalUserOrderSubHistory(UserOrderSubSearchDto userOrderSubSearchDto) {
        return userOrderSubRepository.findAllHistory(userOrderSubSearchDto);

    }
    @Override
    public List<UserOrderSub> selectTotalMobileUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto) {
        return userOrderSubRepository.findMobileAll(userOrderSubSearchDto);

    }
    @Override
    public List<UserOrderSub> selectTotalMobileBuyUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto) {
        return userOrderSubRepository.findMobileBuyAll(userOrderSubSearchDto);

    }
    @Override
    public List<UserOrderSub> selectUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto) {
        return userOrderSubRepository.findInfo(userOrderSubSearchDto);

    }
    @Override
    public List<UserOrderSub> selectUserOrderSubPrice(UserOrderSubSearchDto userOrderSubSearchDto) {
        return userOrderSubRepository.findSupplyPrice(userOrderSubSearchDto);

    }
}
