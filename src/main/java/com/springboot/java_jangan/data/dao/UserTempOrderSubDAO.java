package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrderSub;

import java.util.List;


public interface UserTempOrderSubDAO {


    List<UserTempOrderSub> selectTotalUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);
    List<UserTempOrderSub> selectTotalMobileUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> selectTotalMobileBuyUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> selectUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);



}
