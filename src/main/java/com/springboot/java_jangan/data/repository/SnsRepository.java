package com.springboot.java_jangan.data.repository;
import com.springboot.java_jangan.data.entity.Sns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SnsRepository extends JpaRepository<Sns,Long> {
    Optional<Sns> findByEmail(String nickname);

}
