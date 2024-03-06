package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.userOrderAmount.UserOrderAmountSearchDto;
import com.springboot.java_jangan.data.entity.UserOrderAmount;
import com.springboot.java_jangan.service.UserOrderAmountService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user_order_amount")
@Controller
public class UserOrderAmountController {
    private final UserOrderAmountService userOrderAmountService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserOrderAmountController.class);

    @Autowired
    public UserOrderAmountController(UserOrderAmountService userOrderAmountService){
        this.userOrderAmountService = userOrderAmountService;
    }

    @GetMapping(value= "/select") // 매입처별/품목별 매입,  품목별/상품별 매입단가 조회
    public ResponseEntity<List<UserOrderAmount>> getUserOrderAmount(@ModelAttribute UserOrderAmountSearchDto userOrderAmountSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserOrderAmount> selectedTotalUserOrderAmount = userOrderAmountService.getUserOrderAmount(userOrderAmountSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrderAmount);
    }
   

  



}
