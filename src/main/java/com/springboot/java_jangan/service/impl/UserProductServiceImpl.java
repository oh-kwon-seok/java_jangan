package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.UserProductDAO;
import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserProduct;
import com.springboot.java_jangan.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductServiceImpl implements UserProductService {
    private final UserProductDAO userProductDAO;

    @Autowired
    public UserProductServiceImpl(@Qualifier("userProductDAOImpl") UserProductDAO userProductDAO){
        this.userProductDAO = userProductDAO;
    }



    @Override
    public List<UserProduct> getUserProduct(UserProductSearchDto userProductSearchDto){
        return userProductDAO.selectUserProduct(userProductSearchDto);
    }


}
