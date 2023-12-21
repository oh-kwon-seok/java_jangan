package com.springboot.java_jangan.data.dto.userOrder;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserOrderDto {

    private Long uid;
    private String user_id;
    private Long car_uid;

    private String order_status;
    private String price_status;



    private Long used;
    private String token;


    private List<Map<String, Object>> user_product;
    private List<Map<String, Object>> user_order_sub;


    public UserOrderDto(
                Long uid,
                String user_id,
                Long car_uid,

                String order_status,
                String price_status,
                Long used,
                String token,

                List<Map<String, Object>> user_order_sub
    ){
        this.uid = uid;
        this.user_id = user_id;
        this.car_uid = car_uid;
        this.order_status = order_status;
        this.price_status = price_status;
        this.used = used;
        this.token = token;

        this.user_order_sub = user_order_sub;
    }

}