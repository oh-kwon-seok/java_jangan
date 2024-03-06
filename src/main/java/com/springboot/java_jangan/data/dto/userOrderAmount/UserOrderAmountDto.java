package com.springboot.java_jangan.data.dto.userOrderAmount;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserOrderAmountDto {
    private Long uid;

    private Long user_order_uid;
    private String user_id;
    private String amount_date;
    private Integer amount;
    private Integer totalPrice;

    private String token;

    public UserOrderAmountDto(Long uid, Long user_order_uid, String user_id, String amount_date, Integer amount, Integer totalPrice,String token){
        this.uid = uid;
        this.user_order_uid = user_order_uid;
        this.user_id = user_id;
        this.amount_date = amount_date;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.token = token;

    }

}
