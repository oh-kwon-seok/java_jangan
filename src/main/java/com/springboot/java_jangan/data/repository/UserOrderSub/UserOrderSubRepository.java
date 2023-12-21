package com.springboot.java_jangan.data.repository.UserOrderSub;

import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import com.springboot.java_jangan.data.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userOrderSubRepositorySupport")
public interface UserOrderSubRepository extends JpaRepository<UserOrderSub,String>, UserOrderSubRepositoryCustom {


    List<UserOrderSub> findByUserOrderUid(Long uid);





}
