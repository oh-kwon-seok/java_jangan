package com.springboot.java_jangan.data.dto.userOrderSub;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserOrderSubSearchDto {

    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String search_text;
    private String filter_title;


    private String req_date;

    private String user_order_uid;
    private String user_id;


}
