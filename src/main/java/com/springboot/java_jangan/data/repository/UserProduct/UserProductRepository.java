package com.springboot.java_jangan.data.repository.UserProduct;

import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userProductRepositorySupport")
public interface UserProductRepository extends JpaRepository<UserProduct,String>, UserProductRepositoryCustom {

    UserProduct getById(String id);
    List<UserProduct> findByUserId(String id);
    UserProduct findByUser(User user);




}
