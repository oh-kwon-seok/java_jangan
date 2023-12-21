package com.springboot.java_jangan.data.repository.UserTempOrder;


import com.springboot.java_jangan.data.entity.UserTempOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userTempOrderRepositorySupport")
public interface UserTempOrderRepository extends JpaRepository<UserTempOrder,String>, UserTempOrderRepositoryCustom {

    UserTempOrder getById(String user_id);
    UserTempOrder findByUid(Long uid);

}
