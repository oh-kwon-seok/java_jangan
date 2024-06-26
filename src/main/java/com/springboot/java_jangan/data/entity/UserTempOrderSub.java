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
@Table(name="user_temp_order_sub")
public class UserTempOrderSub extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne(fetch = FetchType.LAZY)  // ToOne은 fetch = FetchType.LAZY로 꼭 !!! 세팅
    @JoinColumn(name="user_temp_order_uid")
    private UserTempOrder userTempOrder;

    @ManyToOne(fetch = FetchType.LAZY)  // ToOne은 fetch = FetchType.LAZY로 꼭 !!! 세팅
    @JoinColumn(name="product_uid")
    private Product product;




    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer buy_price;
    @Column(nullable = false)
    private Integer supply_price;




}
