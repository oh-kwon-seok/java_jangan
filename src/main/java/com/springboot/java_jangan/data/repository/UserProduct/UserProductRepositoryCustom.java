package com.springboot.java_jangan.data.repository.UserProduct;

import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.Car;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.entity.UserProduct;

import java.util.List;

public interface UserProductRepositoryCustom {


    List<UserProduct> findInfo(UserProductSearchDto userProductSearchDto);

}
