package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.UserProductDAO;
import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserProduct;
import com.springboot.java_jangan.data.repository.UserProduct.UserProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserProductDAOImpl implements UserProductDAO {
    
    private final UserProductRepository userProductRepository;
    @Autowired
    public UserProductDAOImpl(UserProductRepository userProductRepository){
        this.userProductRepository = userProductRepository;

    }

    @Override
    public List<UserProduct> selectUserProduct(UserProductSearchDto userProductSearchDto) {
        return userProductRepository.findInfo(userProductSearchDto);

    }
}
