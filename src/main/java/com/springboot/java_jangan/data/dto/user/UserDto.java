package com.springboot.java_jangan.data.dto.user;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserDto {

    private String id;
    private String code;
    private String password;

    private String name;
    private String customer_name;
    private String email;
    private String phone;

    private Long car_uid;

    private String auth;
    private Long used;
    private String token;
    private List<Map<String, Object>> user_product;

    public UserDto( String id,String code,String customer_name,String password,String name,String email,String phone, Long car_uid, String auth, Long used, String token,List<Map<String, Object>> user_product){

        this.name = name;
        this.id = id;
        this.code = code;
        this.password = password;
        this.name = name;
        this.customer_name = customer_name;
        this.email = email;
        this.phone = phone;

        this.car_uid = car_uid;
        this.auth = auth;
        this.used = used;

        this.token = token;
        this.user_product = user_product;

    }

}
