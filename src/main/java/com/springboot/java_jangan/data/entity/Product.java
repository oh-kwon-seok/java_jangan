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
@Table(name="product")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long uid;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="type_uid")
    private Type type;
    @ManyToOne
    @JoinColumn(name="company_uid")
    private Company company;

    @Column(nullable = false)
    private Integer used;


}
