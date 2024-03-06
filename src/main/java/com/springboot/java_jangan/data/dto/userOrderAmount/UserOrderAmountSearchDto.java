package com.springboot.java_jangan.data.dto.userOrderAmount;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserOrderAmountSearchDto {

    private String start_date;
    private String end_date;

    private String user_id;


}
