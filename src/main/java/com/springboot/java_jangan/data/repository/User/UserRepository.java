package com.springboot.java_jangan.data.repository.User;

import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.repository.product.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepositorySupport")
public interface UserRepository extends JpaRepository<User,String>, UserRepositoryCustom {

    User getById(String id);
    User findByCodeAndPhone(String code, String phone);


}
