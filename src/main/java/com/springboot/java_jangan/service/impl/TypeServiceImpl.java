package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.TypeDAO;
import com.springboot.java_jangan.data.dto.type.TypeDto;
import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;
import com.springboot.java_jangan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeDAO typeDAO;

    @Autowired
    public TypeServiceImpl(@Qualifier("typeDAOImpl") TypeDAO typeDAO){
        this.typeDAO = typeDAO;
    }


    @Override
    public List<Type> getTotalType(TypeSearchDto typeSearchDto){
        return typeDAO.selectTotalType(typeSearchDto);
    }

    @Override
    public List<Type> getType(TypeSearchDto typeSearchDto){
        return typeDAO.selectType(typeSearchDto);
    }
    @Override
    public Type saveType(TypeDto typeDto) throws Exception {

        return typeDAO.insertType(typeDto);

    }
    @Override
    public Type updateType(TypeDto typeDto) throws Exception {
        return typeDAO.updateType(typeDto);
    }
    @Override
    public void deleteType(List<Long> uid) throws Exception {
        typeDAO.deleteType(uid);
    }

}
