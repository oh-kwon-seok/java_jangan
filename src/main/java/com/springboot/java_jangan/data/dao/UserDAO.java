package com.springboot.java_jangan.data.dao;

import com.springboot.java_jangan.data.dto.product.ProductDto;
import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.Product;
import com.springboot.java_jangan.data.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> selectTotalUser(UserSearchDto userSearchDto);

    List<User> selectUser(UserSearchDto userSearchDto);


}
