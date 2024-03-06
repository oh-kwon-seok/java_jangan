package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.CompanyDAO;
import com.springboot.java_jangan.data.dto.company.CompanyDto;
import com.springboot.java_jangan.data.dto.company.CompanySearchDto;
import com.springboot.java_jangan.data.entity.Company;
import com.springboot.java_jangan.data.entity.Type;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.repository.company.CompanyRepository;
import com.springboot.java_jangan.data.repository.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyDAOImpl implements CompanyDAO {
    
    private final CompanyRepository companyRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public CompanyDAOImpl(CompanyRepository companyRepository,TypeRepository typeRepository){
        this.companyRepository = companyRepository;
        this.typeRepository = typeRepository;


    }

    public Company insertCompany(CompanyDto companyDto) {



        Company company = new Company();
        Type type = typeRepository.findByUid(companyDto.getType_uid());

        company.setCode(companyDto.getCode());
        company.setName(companyDto.getName());
        company.setEmail(companyDto.getEmail());
        company.setPhone(companyDto.getPhone());
        company.setType(type);


        company.setUsed(Math.toIntExact(companyDto.getUsed()));

        company.setCreated(LocalDateTime.now());

        Company insertCompany = companyRepository.save(company);
        return insertCompany;

    }
    @Override
    public List<Company> selectTotalCompany(CompanySearchDto companySearchDto) {
        return companyRepository.findAll(companySearchDto);

    }

    @Override
    public List<Company> selectCompany(CompanySearchDto companySearchDto) {
        return companyRepository.findInfo(companySearchDto);

    }


    @Override
    public Company updateCompany(CompanyDto companyDto) throws Exception {


        Optional<Company> selectedCompany = companyRepository.findById(companyDto.getUid());

        Company updatedCompany;

        if (selectedCompany.isPresent()) {
            Company company = selectedCompany.get();

            company.setCode(companyDto.getCode());
            company.setName(companyDto.getName());
            company.setEmail(companyDto.getEmail());
            company.setPhone(companyDto.getPhone());
            company.setUsed(Math.toIntExact(companyDto.getUsed()));

            company.setUpdated(LocalDateTime.now());
            updatedCompany = companyRepository.save(company);
        } else {
            throw new Exception();
        }
        return updatedCompany;
    }
    @Override
    public String deleteCompany(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Company> selectedCompany = companyRepository.findById(uid);
            if (selectedCompany.isPresent()) {
                Company company = selectedCompany.get();
                company.setUsed(0);
                company.setDeleted(LocalDateTime.now());
                companyRepository.save(company);
            } else {
                throw new Exception("Company with UID " + uid + " not found.");
            }
        }
        return "Companys deleted successfully";
    }
}
