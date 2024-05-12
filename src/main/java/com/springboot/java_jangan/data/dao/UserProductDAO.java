package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserProduct;

import java.util.List;
import java.util.Map;


public interface UserProductDAO {
    List<UserProduct> selectUserProduct(UserProductSearchDto userProductSearchDto);

    String excelUploadUserProduct(List<Map<String, Object>> requestList) throws Exception;

}
