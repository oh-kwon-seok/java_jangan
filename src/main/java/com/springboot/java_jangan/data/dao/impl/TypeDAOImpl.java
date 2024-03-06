package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.TypeDAO;
import com.springboot.java_jangan.data.dto.type.TypeDto;
import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;
import com.springboot.java_jangan.data.repository.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TypeDAOImpl implements TypeDAO {
    
    private final TypeRepository typeRepository;
    @Autowired
    public TypeDAOImpl(TypeRepository typeRepository){
        this.typeRepository = typeRepository;

    }

    public Type insertType(TypeDto typeDto) {



        Type type = new Type();

        type.setName(typeDto.getName());
        type.setUsed(Math.toIntExact(typeDto.getUsed()));

        type.setCreated(LocalDateTime.now());

        Type insertType = typeRepository.save(type);
        return insertType;

    }
    @Override
    public List<Type> selectTotalType(TypeSearchDto typeSearchDto) {
        return typeRepository.findAll(typeSearchDto);

    }

    @Override
    public List<Type> selectType(TypeSearchDto typeSearchDto) {
        return typeRepository.findInfo(typeSearchDto);

    }


    @Override
    public Type updateType(TypeDto typeDto) throws Exception {


        Optional<Type> selectedType = typeRepository.findById(typeDto.getUid());

        Type updatedType;

        if (selectedType.isPresent()) {
            Type type = selectedType.get();
            type.setName(typeDto.getName());
            type.setUsed(Math.toIntExact(typeDto.getUsed()));

            type.setUpdated(LocalDateTime.now());
            updatedType = typeRepository.save(type);
        } else {
            throw new Exception();
        }
        return updatedType;
    }
    @Override
    public String deleteType(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Type> selectedType = typeRepository.findById(uid);
            if (selectedType.isPresent()) {
                Type type = selectedType.get();
                type.setUsed(0);
                type.setDeleted(LocalDateTime.now());
                typeRepository.save(type);
            } else {
                throw new Exception("Type with UID " + uid + " not found.");
            }
        }
        return "Types deleted successfully";
    }
}
