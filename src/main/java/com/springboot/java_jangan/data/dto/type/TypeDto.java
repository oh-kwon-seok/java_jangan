package com.springboot.java_jangan.data.dto.type;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class TypeDto {

    private Long uid;
    private String name;

    private Long used;
    private String token;

    private List<Map<String, Object>> company;


    public TypeDto(
                Long uid,

                String name,
                Long used,
                String token,
                List<Map<String, Object>> company
    ){
        this.uid = uid;
        this.name = name;
        this.used = used;
        this.token = token;
        this.company = company;

    }

}
