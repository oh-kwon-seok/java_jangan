package com.springboot.java_jangan.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.common.CommonResponse;
import com.springboot.java_jangan.data.dao.UserTempOrderDAO;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_jangan.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_jangan.data.entity.*;
import com.springboot.java_jangan.data.repository.User.UserRepository;
import com.springboot.java_jangan.data.repository.UserTempOrder.UserTempOrderRepository;
import com.springboot.java_jangan.data.repository.UserTempOrderSub.UserTempOrderSubRepository;
import com.springboot.java_jangan.data.repository.car.CarRepository;
import com.springboot.java_jangan.data.repository.product.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserTempOrderDAOImpl implements UserTempOrderDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserTempOrderDAOImpl.class);

    private final UserTempOrderRepository userTempOrderRepository;
    private final UserTempOrderSubRepository userTempOrderSubRepository;

    private final UserRepository userRepository;


    private final CarRepository carRepository;
    private final ProductRepository productRepository;


    @Autowired
    public UserTempOrderDAOImpl(UserTempOrderRepository userTempOrderRepository,
                                UserTempOrderSubRepository userTempOrderSubRepository, UserRepository userRepository,
                                CarRepository carRepository,
                                ProductRepository productRepository) {
        this.userTempOrderRepository = userTempOrderRepository;
        this.userTempOrderSubRepository = userTempOrderSubRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.productRepository = productRepository;
    }

    @Override
    public UserTempOrderResultDto insertUserTempOrder(UserTempOrderDto UserTempOrderDto) throws Exception {


        User user = userRepository.getById(String.valueOf(UserTempOrderDto.getUser_id()));
        Car car = carRepository.findByUid(UserTempOrderDto.getCar_uid());

        UserTempOrder UserTempOrder = new UserTempOrder();

        UserTempOrder.setOrder_status(String.valueOf(UserTempOrderDto.getOrder_status()));

        UserTempOrder.setUser(user);
        UserTempOrder.setCar(car);
        UserTempOrder.setUsed(Math.toIntExact(UserTempOrderDto.getUsed()));
        UserTempOrder.setCreated(LocalDateTime.now());

        UserTempOrder insertUserTempOrder = userTempOrderRepository.save(UserTempOrder);

        Long uid = insertUserTempOrder.getUid();

        LOGGER.info("[uid] : {}",uid);
        UserTempOrder selectedUserTempOrder = userTempOrderRepository.findByUid(uid);

        List<Map<String, Object>> UserTempOrderSubList = UserTempOrderDto.getUser_temp_order_sub();

        LOGGER.info("[UserTempOrder] : {}",selectedUserTempOrder);
        UserTempOrderResultDto UserTempOrderResultDto = new UserTempOrderResultDto();

        if (UserTempOrderSubList != null) {

            for (Map<String, Object> UserTempOrderSubData : UserTempOrderSubList) {
                UserTempOrderSub userTempOrderSub = new UserTempOrderSub();
                userTempOrderSub.setUserTempOrder(selectedUserTempOrder);

                userTempOrderSub.setQty(Integer.parseInt(UserTempOrderSubData.get("qty").toString()));

                userTempOrderSub.setPrice(Integer.parseInt(UserTempOrderSubData.get("price").toString()));




                userTempOrderSub.setBuy_price(Integer.parseInt(UserTempOrderSubData.get("buy_price").toString()));



                userTempOrderSub.setSupply_price(Integer.parseInt(UserTempOrderSubData.get("supply_price").toString()));


                // product_uid 값이 있다면 product를 가져와서 userProduct에 설정
                if (UserTempOrderSubData.containsKey("uid")) {
                    Long productUid = Long.parseLong(UserTempOrderSubData.get("uid").toString());
                    Product product = productRepository.findById(productUid)
                            .orElseThrow(() -> new RuntimeException("Product not found for product_uid: " + productUid));
                    userTempOrderSub.setProduct(product);
                }
                userTempOrderSub.setCreated(LocalDateTime.now());
                userTempOrderSub.setUpdated(LocalDateTime.now());

                userTempOrderSubRepository.save(userTempOrderSub);
            }



            setSuccessResult(UserTempOrderResultDto);
            return UserTempOrderResultDto;

        }else {
            setFailResult(UserTempOrderResultDto);
            return UserTempOrderResultDto;

        }
    }


    @Override
    public List<UserTempOrder> selectTotalUserTempOrder(UserTempOrderSearchDto UserTempOrderSearchDto) {
        return userTempOrderRepository.findAll(UserTempOrderSearchDto);

    }




    private void setSuccessResult(UserTempOrderResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(UserTempOrderResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }

}