package com.springboot.java_jangan.data.repository.company;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.company.CompanySearchDto;
import com.springboot.java_jangan.data.entity.Company;
import com.springboot.java_jangan.data.entity.QCompany;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CompanyRepositoryCustomImpl extends QuerydslRepositorySupport implements CompanyRepositoryCustom {

    public CompanyRepositoryCustomImpl(){
        super(Company.class);
    }

    @Override
    public List<Company> findAll(CompanySearchDto companySearchDto){
        QCompany company = QCompany.company;

        String filter_title = companySearchDto.getFilter_title();
        String search_text = companySearchDto.getSearch_text();

        LocalDateTime start_date = companySearchDto.getStart_date();
        LocalDateTime end_date = companySearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){

            if (company.code != null) {
                builder.or(company.code.like("%" + search_text + "%"));
            }
            if (company.name != null) {
                builder.or(company.name.like("%" + search_text + "%"));
            }
            if (company.email != null) {
                builder.or(company.email.like("%" + search_text + "%"));
            }
            if (company.phone != null) {
                builder.or(company.email.like("%" + search_text + "%"));
            }
        }else {
            if("code".equals(filter_title)){
                builder.and(company.code.like("%" + search_text + "%"));
            }
            else if("name".equals(filter_title)){
                builder.and(company.name.like("%" + search_text + "%"));
            }else if("phone".equals(filter_title)){
                builder.and(company.phone.like("%" + search_text + "%"));
            }else if("email".equals(filter_title)){
                builder.and(company.email.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = company.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = company.used.eq(1);

        List<Company> companyList = from(company)
                .select(company)
                .where(used,dateRange)
                .fetch();

        return companyList;
    }
    @Override
    public List<Company> findInfo(CompanySearchDto CompanySearchDto){

        QCompany company = QCompany.company;

        Predicate used = company.used.eq(1);

        List<Company> companyList = from(company)
                .select(company)
                .where(used)
                .fetch();

        return companyList;
    }




}
