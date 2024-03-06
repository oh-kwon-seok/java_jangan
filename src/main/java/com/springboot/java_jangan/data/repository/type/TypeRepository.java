package com.springboot.java_jangan.data.repository.type;

import com.springboot.java_jangan.data.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typeRepositorySupport")
public interface TypeRepository extends JpaRepository<Type,Long>, TypeRepositoryCustom {

    Type findByUid(Long uid);

    Type findByName(String name);
}
