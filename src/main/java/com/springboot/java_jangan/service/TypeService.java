package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.type.TypeDto;
import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    List<Type> getTotalType(TypeSearchDto typeSearchDto);

    List<Type> getType(TypeSearchDto typeSearchDto);


    Type saveType(TypeDto typeDto) throws Exception;

    Type updateType(TypeDto typeDto) throws Exception;

    void deleteType(List<Long> uid) throws Exception;


}
