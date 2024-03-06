package com.springboot.java_jangan.data.dto.type;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeResultDto {
    private boolean success;
    private int code;
    private String msg;


}