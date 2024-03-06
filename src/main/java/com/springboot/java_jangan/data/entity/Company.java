package com.springboot.java_jangan.data.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="company")
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long uid;

    @ManyToOne(fetch = FetchType.EAGER)  // To,aOne은 fetch = FetchType.LAZY로 꼭 !!! 세팅
    @JoinColumn(name="type_uid")
    private Type type;


    @Column(nullable = false)
    private String code; // 사업자번호

    @Column(nullable = false)
    private String name; // 회사명

    @Column
    private String phone; // 연락처

    @Column
    private String email; // 연락처

    @Column(nullable = false)
    private Integer used;

}
