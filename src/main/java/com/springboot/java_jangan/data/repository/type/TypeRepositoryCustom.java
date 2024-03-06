package com.springboot.java_jangan.data.repository.type;

import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;

import java.util.List;

public interface TypeRepositoryCustom {
    List<Type> findAll(TypeSearchDto typeSearchDto);
    List<Type> findInfo(TypeSearchDto typeSearchDto);

}
