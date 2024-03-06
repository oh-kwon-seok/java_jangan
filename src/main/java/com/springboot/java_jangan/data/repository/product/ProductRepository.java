package com.springboot.java_jangan.data.repository.product;

import com.springboot.java_jangan.data.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product,Long>, ProductRepositoryCustom {



    Product findByNameAndType_nameAndCompany_name(String name, String typeName,String companyName);

}
