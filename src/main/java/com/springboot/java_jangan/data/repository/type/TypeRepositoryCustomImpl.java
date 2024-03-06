package com.springboot.java_jangan.data.repository.type;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;
import com.springboot.java_jangan.data.entity.QType;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TypeRepositoryCustomImpl extends QuerydslRepositorySupport implements TypeRepositoryCustom {

    public TypeRepositoryCustomImpl(){
        super(Type.class);
    }

    @Override
    public List<Type> findAll(TypeSearchDto typeSearchDto){
        QType type = QType.type;

        String filter_title = typeSearchDto.getFilter_title();
        String search_text = typeSearchDto.getSearch_text();

        LocalDateTime start_date = typeSearchDto.getStart_date();
        LocalDateTime end_date = typeSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (type.name != null) {
                builder.or(type.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(type.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = type.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = type.used.eq(1);

        List<Type> typeList = from(type)
                .select(type)
                .where(used,dateRange)
                .fetch();

        return typeList;
    }
    @Override
    public List<Type> findInfo(TypeSearchDto TypeSearchDto){

        QType type = QType.type;

        Predicate used = type.used.eq(1);

        List<Type> typeList = from(type)
                .select(type)
                .where(used)
                .fetch();

        return typeList;
    }




}
