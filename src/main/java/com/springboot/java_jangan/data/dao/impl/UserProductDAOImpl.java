package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.UserProductDAO;
import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.Product;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.entity.UserProduct;
import com.springboot.java_jangan.data.repository.User.UserRepository;
import com.springboot.java_jangan.data.repository.UserProduct.UserProductRepository;

import com.springboot.java_jangan.data.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserProductDAOImpl implements UserProductDAO {
    
    private final UserProductRepository userProductRepository;
    private final UserRepository userRepository ;
    private final ProductRepository productRepository;

    @Autowired
    public UserProductDAOImpl(UserProductRepository userProductRepository,
     UserRepository userRepository,
     ProductRepository productRepository
    ){
        this.userProductRepository = userProductRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<UserProduct> selectUserProduct(UserProductSearchDto userProductSearchDto) {
        return userProductRepository.findInfo(userProductSearchDto);

    }
    @Override
    public String excelUploadUserProduct(List<Map<String, Object>> requestList) throws Exception {

        for (Map<String, Object> data : requestList) {

            String company_code = String.valueOf(data.get("company_code"));

            String name = String.valueOf(data.get("name"));

            Optional<User> selectedUser = userRepository.findById(company_code);


            if (selectedUser.isPresent()) {

                Optional<Product> selectedProduct = Optional.ofNullable(productRepository.findByNameAndUsed(name,1L));

                if (selectedProduct.isPresent()) {
                    Product product = selectedProduct.get();
                    User user = selectedUser.get();

                    UserProduct userProduct = new UserProduct();

                    userProduct.setUser(user);
                    userProduct.setProduct(product);
                    userProduct.setUsed(1);

                    userProduct.setQty(0);
                    userProduct.setCreated(LocalDateTime.now());
                    userProductRepository.save(userProduct);

                }

            }


        }
        return "BOOKMARK_ESTIMATE uploaded successfully";
    }
}
