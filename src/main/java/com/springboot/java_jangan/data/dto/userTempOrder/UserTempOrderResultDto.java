package com.springboot.java_jangan.data.dto.userTempOrder;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTempOrderResultDto {
    private boolean success;
    private int code;
    private String msg;


}