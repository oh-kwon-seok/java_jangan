package com.springboot.java_jangan.data.dto.userProduct;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserProductDto {
    private Long uid;

    private String user_id;
    private Long product_uid;
    private Integer qty;
    private Long used;
    private String token;

    public UserProductDto(Long uid,String user_id, Long product_uid,Integer qty, Long used,String token){
        this.uid = uid;
        this.user_id = user_id;
        this.product_uid = product_uid;
        this.qty = qty;
        this.used = used;

        this.token = token;

    }

}
