package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;

import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserOrder;
import com.springboot.java_jangan.data.entity.UserOrderSub;
import com.springboot.java_jangan.service.UserOrderSubService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user_order_sub")
@Controller
public class UserOrderSubController {
    private final UserOrderSubService userOrderSubService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserOrderSubController.class);

    @Autowired
    public UserOrderSubController(UserOrderSubService userOrderSubService){
        this.userOrderSubService = userOrderSubService;
    }

    @GetMapping(value= "/select") // 매입처별/품목별 매입,  품목별/상품별 매입단가 조회
    public ResponseEntity<List<UserOrderSub>> getTotalUserOrderSub(@ModelAttribute UserOrderSubSearchDto userOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserOrderSub> selectedTotalUserOrderSub = userOrderSubService.getTotalUserOrderSub(userOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrderSub);
    }
    @GetMapping(value= "/history_select") // 매입처별/품목별 매입,  품목별/상품별 매입단가 조회
    public ResponseEntity<List<UserOrderSub>> getTotalUserOrderSubHistory(@ModelAttribute UserOrderSubSearchDto userOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserOrderSub> selectedTotalUserOrderSub = userOrderSubService.getTotalUserOrderSubHistory(userOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrderSub);
    }

    @GetMapping(value= "/mobile_select") // 모바일에서 셀렉트
    public ResponseEntity<List<UserOrderSub>> getTotalMobileUserOrderSub(@ModelAttribute UserOrderSubSearchDto userOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserOrderSub> selectedTotalUserOrderSub = userOrderSubService.getTotalMobileUserOrderSub(userOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrderSub);
    }

    @GetMapping(value= "/mobile_buy_select") // 모바일에서 셀렉트
    public ResponseEntity<List<UserOrderSub>> getTotalMobileBuyUserOrderSub(@ModelAttribute UserOrderSubSearchDto userOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserOrderSub> selectedTotalUserOrderSub = userOrderSubService.getTotalMobileBuyUserOrderSub(userOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrderSub);
    }

    @GetMapping(value= "/info_select")
    public ResponseEntity<List<UserOrderSub>> getUserOrderSub(@ModelAttribute UserOrderSubSearchDto UserOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<UserOrderSub> selectedTotalUserOrderSub = userOrderSubService.getUserOrderSub(UserOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrderSub] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrderSub);

    }



}
