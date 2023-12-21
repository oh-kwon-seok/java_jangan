package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dao.UserOrderDAO;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderResultDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.UserOrder;
import com.springboot.java_jangan.service.UserOrderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user_order")
@Controller
public class UserOrderController {
    private final UserOrderService userOrderService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserOrderController.class);

    @Autowired
    public UserOrderController(UserOrderService userOrderService){
        this.userOrderService = userOrderService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<UserOrder>> getTotalUserOrder(@ModelAttribute UserOrderSearchDto userOrderSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<UserOrder> selectedTotalUserOrder = userOrderService.getTotalUserOrder(userOrderSearchDto);

        LOGGER.info("[getTotalUserOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserOrder);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public UserOrderResultDto createUserOrder(@RequestBody UserOrderDto userOrderDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[userOrderDto]  : {}", userOrderDto);
        UserOrderResultDto userOrderResultDto = userOrderService.saveUserOrder(userOrderDto);
        LOGGER.info("[createUserOrder] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return  userOrderResultDto;

    }



    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public UserOrderResultDto updateUserOrder(@RequestBody UserOrderDto userOrderDto)
            throws Exception{


        UserOrderResultDto userOrderResultDto = userOrderService.updateUserOrder(userOrderDto);
        return userOrderResultDto;
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteUserOrder(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        userOrderService.deleteUserOrder(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
