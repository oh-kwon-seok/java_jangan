package com.springboot.java_jangan.data.repository.UserOrderAmount;

import com.springboot.java_jangan.data.entity.UserOrderAmount;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userOrderAmountRepositorySupport")
public interface UserOrderAmountRepository extends JpaRepository<UserOrderAmount,String>, UserOrderAmountRepositoryCustom {


    List<UserOrderAmount> findByUserOrderUid(Long uid);





}
