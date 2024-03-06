package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.type.TypeDto;
import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;

import java.util.List;


public interface TypeDAO {
    Type insertType(TypeDto carDto);

    List<Type> selectTotalType(TypeSearchDto TypeSearchDto);
    List<Type> selectType(TypeSearchDto carSearchDto);

    Type updateType(TypeDto carDto) throws Exception;

    String deleteType(List<Long> uid) throws Exception;


}
