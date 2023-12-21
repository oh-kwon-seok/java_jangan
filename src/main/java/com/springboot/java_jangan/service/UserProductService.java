package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProductService {
    
    List<UserProduct> getUserProduct(UserProductSearchDto userProductSearchDto);



}
