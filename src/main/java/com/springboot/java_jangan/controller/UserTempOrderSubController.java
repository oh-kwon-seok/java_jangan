package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_jangan.data.entity.UserTempOrderSub;
import com.springboot.java_jangan.service.UserTempOrderSubService;
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
@RequestMapping("/user_temp_order_sub")
@Controller
public class UserTempOrderSubController {
    private final UserTempOrderSubService userTempOrderSubService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserTempOrderSubController.class);

    @Autowired
    public UserTempOrderSubController(UserTempOrderSubService userTempOrderSubService){
        this.userTempOrderSubService = userTempOrderSubService;
    }

    @GetMapping(value= "/select") // 매입처별/품목별 매입,  품목별/상품별 매입단가 조회
    public ResponseEntity<List<UserTempOrderSub>> getTotalUserTempOrderSub(@ModelAttribute UserTempOrderSubSearchDto userTempOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserTempOrderSub> selectedTotalUserTempOrderSub = userTempOrderSubService.getTotalUserTempOrderSub(userTempOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserTempOrderSub);
    }
    @GetMapping(value= "/mobile_select") // 모바일에서 셀렉트
    public ResponseEntity<List<UserTempOrderSub>> getTotalMobileUserTempOrderSub(@ModelAttribute UserTempOrderSubSearchDto userTempOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();
        List<UserTempOrderSub> selectedTotalUserTempOrderSub = userTempOrderSubService.getTotalMobileUserTempOrderSub(userTempOrderSubSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserTempOrderSub);
    }

    @GetMapping(value= "/info_select")
    public ResponseEntity<List<UserTempOrderSub>> getUserTempOrderSub(@ModelAttribute UserTempOrderSubSearchDto UserTempOrderSubSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<UserTempOrderSub> selectedTotalUserTempOrderSub = userTempOrderSubService.getUserTempOrderSub(UserTempOrderSubSearchDto);

        LOGGER.info("[getTotalUserTempOrderSub] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserTempOrderSub);

    }



}
