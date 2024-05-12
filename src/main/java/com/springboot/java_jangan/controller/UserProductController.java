package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.userProduct.UserProductDto;
import com.springboot.java_jangan.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_jangan.data.entity.UserProduct;
import com.springboot.java_jangan.service.UserProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user_product")
@Controller
public class UserProductController {
    private final UserProductService userProductService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserProductController.class);

    @Autowired
    public UserProductController(UserProductService userProductService){
        this.userProductService = userProductService;
    }


    @GetMapping(value= "/info_select")
    public ResponseEntity<List<UserProduct>> getUserProduct(@ModelAttribute UserProductSearchDto userProductSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<UserProduct> selectedTotalUserProduct = userProductService.getUserProduct(userProductSearchDto);

        LOGGER.info("[getTotalUserProduct] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserProduct);

    }
    @PostMapping(value= "/excel_upload", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> excelUploadUserProduct(@RequestBody Map<String, List<Map<String, Object>>> requestMap) throws Exception {
        List<Map<String, Object>> requestList = requestMap.get("data");
        LOGGER.info("LIST : {}",requestList);


        userProductService.excelUploadUserProduct(requestList);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 업로드되었습니다.");
    }



}
