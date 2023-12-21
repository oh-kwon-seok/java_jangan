package com.springboot.java_jangan.data.dto.product;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class ProductDto {
    private Long uid;

    private Long company_uid;

    private String name;
    private String type;

    private Long used;
    private String token;

    public ProductDto(Long uid,Long company_uid, String name,String type, Long used,String token){
        this.uid = uid;
        this.company_uid = company_uid;

        this.name = name;
        this.type = type;

        this.used = used;

        this.token = token;

    }

}
