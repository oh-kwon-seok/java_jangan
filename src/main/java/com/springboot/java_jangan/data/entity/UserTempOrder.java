package com.springboot.java_jangan.data.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="user_temp_order")
public class UserTempOrder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="car_uid")
    private Car car;

    @Column(nullable = false)
    private String order_status;


    @Column(nullable = false)
    private Integer used;

    @Formula("(SELECT COALESCE(SUM(uos.buy_price), 0) FROM user_temp_order_sub uos WHERE uos.user_temp_order_uid = uid)")
    private BigDecimal totalBuyPrice;

    @Formula("(SELECT COALESCE(SUM(uos.supply_price), 0) FROM user_temp_order_sub uos WHERE uos.user_temp_order_uid = uid)")
    private BigDecimal totalSupplyPrice;


}
