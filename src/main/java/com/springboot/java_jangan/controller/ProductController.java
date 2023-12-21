package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.product.ProductDto;

import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.Product;
import com.springboot.java_jangan.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@Controller
public class ProductController {
    private final ProductService productService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<Product>> getTotalProduct(@ModelAttribute ProductSearchDto productSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Product> selectedTotalProduct = productService.getTotalProduct(productSearchDto);

        LOGGER.info("[getTotalProduct] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalProduct);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[productDto]  : {}", productDto);
        Product insertProduct = productService.saveProduct(productDto);
        LOGGER.info("[createProduct] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertProduct);




    }

    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto)
            throws Exception{

        Product updateProduct = productService.updateProduct(productDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[productDto]  : {}", productDto);

        LOGGER.info("[updateProduct] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteProduct(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        productService.deleteProduct(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @PostMapping(value= "/excel_upload", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> excelUploadProduct(@RequestBody Map<String, List<Map<String, Object>>> requestMap) throws Exception {
        List<Map<String, Object>> requestList = requestMap.get("data");
        LOGGER.info("LIST : {}",requestList);

                productService.excelUploadProduct(requestList);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
