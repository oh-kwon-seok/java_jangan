package com.springboot.java_jangan.data.repository.UserTempOrder;

import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrder;

import java.util.List;

public interface UserTempOrderRepositoryCustom {



    List<UserTempOrder> findAll(UserTempOrderSearchDto userTempOrderSearchDto);


}
