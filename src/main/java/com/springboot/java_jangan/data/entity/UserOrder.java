package com.springboot.java_jangan.data.entity;


import jakarta.persistence.*;
import lombok.*;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="user_order")
public class UserOrder extends BaseEntity{

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
    private String price_status;

    @Column
    private String description;




    @Column
    private String image_url;
    @Column
    private String ship_image_url;

    @Column
    private String req_date;

    @Column
    private String req_des;


    @Column(nullable = false)
    private Integer used;

    @Formula("(SELECT COALESCE(SUM(uos.buy_price), 0) FROM user_order_sub uos WHERE uos.user_order_uid = uid)")
    private BigDecimal totalBuyPrice;

    @Formula("(SELECT COALESCE(SUM(uos.supply_price), 0) FROM user_order_sub uos WHERE uos.user_order_uid = uid)")
    private BigDecimal totalSupplyPrice;


    @Formula("(SELECT COALESCE(SUM(uos.supply_price), 0) " +
            "FROM user_order_sub uos " +
            "WHERE uos.user_order_uid IN " +
            "  (SELECT uo.uid FROM user_order uo WHERE uo.user_id = user_id AND uo.price_status = '미수금'))")
    private BigDecimal totalUnpaidPrice;



}
