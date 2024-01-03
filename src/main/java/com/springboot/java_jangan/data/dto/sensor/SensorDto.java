package com.springboot.java_jangan.data.dto.sensor;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString



public class SensorDto {
    private Long uid;
    private String code;
    private Double data;
    private String type;
    private String token;


    public SensorDto(Long uid, String code, Double data,String type, String token){
        this.uid = uid;
        this.code = code;
        this.data = data;
        this.type = type;

        this.token = token;

    }

}
