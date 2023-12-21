package com.springboot.java_jangan.data.repository.UserTempOrderSub;

import com.springboot.java_jangan.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrderSub;

import java.util.List;

public interface UserTempOrderSubRepositoryCustom {



    List<UserTempOrderSub> findAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto);
    List<UserTempOrderSub> findMobileAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> findMobileBuyAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> findInfo(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

}
