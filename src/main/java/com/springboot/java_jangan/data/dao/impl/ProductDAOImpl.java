package com.springboot.java_jangan.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dao.ProductDAO;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.dto.product.ProductDto;
import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.*;

import com.springboot.java_jangan.data.repository.company.CompanyRepository;
import com.springboot.java_jangan.data.repository.product.ProductRepository;

import com.springboot.java_jangan.data.repository.type.TypeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductDAOImpl.class);

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;

    private final TypeRepository typeRepository;




    @Autowired
    public ProductDAOImpl(ProductRepository productRepository,

                          CompanyRepository companyRepository,
                          TypeRepository typeRepository
                          ) {
        this.productRepository = productRepository;
        this.companyRepository = companyRepository;
        this.typeRepository = typeRepository;

    }

    @Override
    public Product insertProduct(ProductDto productDto) throws Exception {

        Company company = companyRepository.findByUid(productDto.getCompany_uid());
        Type type = typeRepository.findByUid(productDto.getType_uid());

        Product product = new Product();
        product.setName(productDto.getName());
        product.setType(type);
        product.setCompany(company);
        product.setUsed(Math.toIntExact(productDto.getUsed()));

        product.setCreated(LocalDateTime.now());


        LOGGER.info("[product : ]: {}", product);


        Product insertProduct = productRepository.save(product);
        return insertProduct;

    }

    @Override
    public List<Product> selectTotalProduct(ProductSearchDto productSearchDto) {
        return productRepository.findAll(productSearchDto);

    }
    @Override
    public List<Product> selectProduct(ProductSearchDto productSearchDto) {
        return productRepository.findInfo(productSearchDto);

    }

    @Override
    public Product updateProduct(ProductDto productDto) throws Exception {

        Company company = companyRepository.findByUid(productDto.getCompany_uid());
        Type type = typeRepository.findByUid(productDto.getType_uid());

        Optional<Product> selectedProduct = productRepository.findById(productDto.getUid());

        Product updatedProduct;

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(productDto.getName());
            product.setType(type);
            product.setCompany(company);
            product.setUsed(Math.toIntExact(productDto.getUsed()));

            product.setUpdated(LocalDateTime.now());
            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public String deleteProduct(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Product> selectedProduct = productRepository.findById(uid);
            if (selectedProduct.isPresent()) {
                Product product = selectedProduct.get();
                product.setUsed(0);
                product.setDeleted(LocalDateTime.now());
                productRepository.save(product);
            } else {
                throw new Exception("Product with UID " + uid + " not found.");
            }
        }
        return "Products deleted successfully";
    }

    @Override
    public String excelUploadProduct(List<Map<String, Object>> requestList) throws Exception {

        for (Map<String, Object> data : requestList) {
            String name = (String) data.get("name");
            String typeName = (String) data.get("type_name");
            String companyName = (String) data.get("company_name");

            Type type = typeRepository.findByName(typeName);
            Company company = companyRepository.findByName(companyName);



            // 예시로 이름과 수량이 모두 일치하는 Product를 찾는 메서드를 가정
            Optional<Product> selectedProduct = Optional.ofNullable(productRepository.findByNameAndType_nameAndCompany_name(name,typeName,companyName));

            if (selectedProduct.isPresent()) {
                Product product = selectedProduct.get();

                product.setName(name);
                product.setType(type);
                product.setCompany(company);

                product.setUsed(1);
                product.setUpdated(LocalDateTime.now());
                productRepository.save(product);
            } else {
                Product product = new Product();

                product.setName(name);
                product.setType(type);
                product.setCompany(company);

                product.setUsed(1);

                product.setCreated(LocalDateTime.now());
                productRepository.save(product);


            }
        }
        return "Products deleted successfully";
    }
}