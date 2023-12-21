package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserProduct;

import java.util.List;


public interface UserProductDAO {
    List<UserProduct> selectUserProduct(UserProductSearchDto userProductSearchDto);



}
