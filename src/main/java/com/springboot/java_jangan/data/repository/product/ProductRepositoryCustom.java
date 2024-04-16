package com.springboot.java_jangan.data.repository.product;

import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findAll(ProductSearchDto productSearchDto);

    List<Product> findInfo(ProductSearchDto productSearchDto);


}
