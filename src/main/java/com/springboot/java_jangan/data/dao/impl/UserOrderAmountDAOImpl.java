package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.UserOrderAmountDAO;

import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;

import com.springboot.java_jangan.data.entity.UserOrderAmount;
import com.springboot.java_jangan.data.repository.UserOrderAmount.UserOrderAmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserOrderAmountDAOImpl implements UserOrderAmountDAO {

    private final UserOrderAmountRepository userOrderAmountRepository;
    @Autowired
    public UserOrderAmountDAOImpl(UserOrderAmountRepository userOrderAmountRepository){
        this.userOrderAmountRepository = userOrderAmountRepository;

    }

    @Override
    public List<UserOrderAmount> selectUserOrderAmount(UserOrderAmountSearchDto userOrderAmountSearchDto) {
        return userOrderAmountRepository.findAll(userOrderAmountSearchDto);

    }

}
