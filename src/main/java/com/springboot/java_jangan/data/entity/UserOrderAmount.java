package com.springboot.java_jangan.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="user_order_amount")
public class UserOrderAmount extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne(fetch = FetchType.EAGER)  // ToOne은 fetch = FetchType.LAZY로 꼭 !!! 세팅
    @JoinColumn(name="user_order_uid")
    private UserOrder userOrder;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @Column(nullable = false)
    private String amount_date;

    @Column(nullable = false)
    private Integer amount;




}
