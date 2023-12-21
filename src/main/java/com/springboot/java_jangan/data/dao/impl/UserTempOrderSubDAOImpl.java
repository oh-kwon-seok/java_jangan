package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.UserTempOrderSubDAO;
import com.springboot.java_jangan.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrderSub;
import com.springboot.java_jangan.data.repository.UserTempOrderSub.UserTempOrderSubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTempOrderSubDAOImpl implements UserTempOrderSubDAO {

    private final UserTempOrderSubRepository userTempOrderSubRepository;
    @Autowired
    public UserTempOrderSubDAOImpl(UserTempOrderSubRepository userTempOrderSubRepository){
        this.userTempOrderSubRepository = userTempOrderSubRepository;

    }

    @Override
    public List<UserTempOrderSub> selectTotalUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto) {
        return userTempOrderSubRepository.findAll(userTempOrderSubSearchDto);

    }
    @Override
    public List<UserTempOrderSub> selectTotalMobileUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto) {
        return userTempOrderSubRepository.findMobileAll(userTempOrderSubSearchDto);

    }
    @Override
    public List<UserTempOrderSub> selectTotalMobileBuyUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto) {
        return userTempOrderSubRepository.findMobileBuyAll(userTempOrderSubSearchDto);

    }
    @Override
    public List<UserTempOrderSub> selectUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto) {
        return userTempOrderSubRepository.findInfo(userTempOrderSubSearchDto);

    }
}
