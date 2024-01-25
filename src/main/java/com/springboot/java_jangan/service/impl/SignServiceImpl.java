package com.springboot.java_jangan.service.impl;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.common.CommonResponse;
import com.springboot.java_jangan.config.security.JwtTokenProvider;
import com.springboot.java_jangan.data.dao.UserDAO;
import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.dto.user.UserDto;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.*;
import com.springboot.java_jangan.data.repository.History.HistoryRepository;
import com.springboot.java_jangan.data.repository.User.UserRepository;
import com.springboot.java_jangan.data.repository.UserProduct.UserProductRepository;
import com.springboot.java_jangan.data.repository.car.CarRepository;
import com.springboot.java_jangan.data.repository.product.ProductRepository;
import com.springboot.java_jangan.service.SignService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public class SignServiceImpl implements SignService {
    private final Logger LOGGER = (Logger)LoggerFactory.getLogger(SignServiceImpl.class);
    private final UserDAO userDao;


    public UserRepository userRepository;
    public ProductRepository productRepository;

    public HistoryRepository historyRepository;
    public UserProductRepository userProductRepository;

    public CarRepository carRepository;

    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(@Qualifier("userDAOImpl") UserDAO userDAO, UserRepository userRepository, ProductRepository productRepository,  UserProductRepository userProductRepository,CarRepository carRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, HistoryRepository historyRepository){
        this.userDao = userDAO;
        this.userRepository = userRepository;
        this.userProductRepository = userProductRepository;

        this.productRepository = productRepository;

        this.historyRepository = historyRepository;

        this.carRepository = carRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;

    }



    @Override
    public List<User> getTotalUser(UserSearchDto userSearchDto){
        return userDao.selectTotalUser(userSearchDto);

    }

    @Override
    public List<User> getUser(UserSearchDto userSearchDto){
        return userDao.selectUser(userSearchDto);
    }

    @Override
    public  SignUpResultDto save(UserDto userDto) throws RuntimeException{
        String id = userDto.getId();
        String code = userDto.getCode();
        String name = userDto.getName();
        String customer_name = userDto.getCustomer_name();

        String password = userDto.getPassword();

        String email = userDto.getEmail();
        String phone = userDto.getPhone();
        String auth = userDto.getAuth();


        Car car = carRepository.findByUid(Long.valueOf(userDto.getCar_uid()));
        Optional<User> selectedUser = Optional.ofNullable(userRepository.getById(userDto.getId()));

        LOGGER.info("[selectUser] : {}",selectedUser.isPresent());

        User user;
        SignUpResultDto signUpResultDto = new SignUpResultDto();

        if(selectedUser.isPresent()){

            setFailResult(signUpResultDto);
            return signUpResultDto;

        }else{
            if (auth.equalsIgnoreCase("admin")) {
                user = User.builder()
                        .id(id)
                        .code(code)
                        .name(name)
                        .customer_name(customer_name)

                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .phone(phone)
                        .car(car)
                        .auth(Collections.singletonList("ROLE_ADMIN"))
                        .created(LocalDateTime.now())
                        .used(1)
                        .build();
                userRepository.save(user);

                setSuccessResult(signUpResultDto);
                return signUpResultDto;

            } else if(auth.equalsIgnoreCase("user")){
                user = User.builder()
                        .id(id)
                        .code(code)
                        .name(name)
                        .customer_name(customer_name)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .phone(phone)
                        .car(car)
                        .auth(Collections.singletonList("ROLE_USER"))
                        .created(LocalDateTime.now())
                        .used(1)
                        .build();
                userRepository.save(user);
                setSuccessResult(signUpResultDto);
                return signUpResultDto;
            }else{
                throw new RuntimeException();
            }

        }


    }

    @Override
    public  SignUpResultDto update(UserDto userDto) throws RuntimeException{
        String id = userDto.getId();
        String code = userDto.getCode();
        String name = userDto.getName();
        String customer_name = userDto.getCustomer_name();

        String password = userDto.getPassword();


        String email = userDto.getEmail();
        String phone = userDto.getPhone();
        String auth = userDto.getAuth();


        Car car = carRepository.findByUid(Long.valueOf(userDto.getCar_uid()));


        Optional<User> selectedUser = Optional.ofNullable(userRepository.getById(userDto.getId()));




        User user;
        SignUpResultDto signUpResultDto = new SignUpResultDto();
        List<Map<String, Object>> userProductList = userDto.getUser_product();



        if (userProductList != null) {
            User setId = userRepository.getById(userDto.getId());
            List<UserProduct> deletedData = userProductRepository.findByUserId(String.valueOf(userDto.getId()));



            userProductRepository.deleteAll(deletedData);


            for (Map<String, Object> userProductData : userProductList) {
                UserProduct userProduct = new UserProduct();
                // userProduct에 필요한 데이터를 userProductData에서 가져와 설정
                // 예시: userProduct.setName(userProductData.get("name").toString());
                userProduct.setQty(Integer.parseInt(userProductData.get("qty").toString()));
                userProduct.setUser(setId);

                // product_uid 값이 있다면 product를 가져와서 userProduct에 설정
                if (userProductData.containsKey("uid")) {
                    Long productUid = Long.parseLong(userProductData.get("uid").toString());
                    Product product = productRepository.findById(productUid)
                            .orElseThrow(() -> new RuntimeException("Product not found for product_uid: " + productUid));
                    userProduct.setProduct(product);
                }
                userProduct.setCreated(LocalDateTime.now());
                userProduct.setUpdated(LocalDateTime.now());
                userProduct.setUsed(1);

                userProductRepository.save(userProduct);
            }
        }


        if(selectedUser.isPresent()){
            if (auth.equalsIgnoreCase("admin")) {
                user = User.builder()
                        .id(id)
                        .code(code)
                        .name(name)
                        .password(passwordEncoder.encode(password))
                        .customer_name(customer_name)
                        .email(email)
                        .phone(phone)
                        .car(car)
                        .auth(Collections.singletonList("ROLE_ADMIN"))

                        .updated(LocalDateTime.now())
                        .used(Math.toIntExact(userDto.getUsed()))
                        .build();
                userRepository.save(user);
                // UserProduct 저장

                setSuccessResult(signUpResultDto);
                return signUpResultDto;

            } else if(auth.equalsIgnoreCase("user")){
                user = User.builder()
                        .id(id)
                        .code(code)
                        .name(name)
                        .password(passwordEncoder.encode(password))
                        .customer_name(customer_name)
                        .email(email)
                        .phone(phone)
                        .car(car)
                        .auth(Collections.singletonList("ROLE_USER"))
                        .updated(LocalDateTime.now())
                        .used(Math.toIntExact(userDto.getUsed()))
                        .build();
                userRepository.save(user);






                setSuccessResult(signUpResultDto);
                return signUpResultDto;
            }else{
                throw new RuntimeException();
            }

        }else{
            setFailResult(signUpResultDto);
            return signUpResultDto;


        }

    }



    @Override
    public  SignUpResultDto mobileUpdate(UserDto userDto) throws RuntimeException{
        String id = userDto.getId();
        String code = userDto.getCode();
        String name = userDto.getName();
        String customer_name = userDto.getCustomer_name();

        String password = userDto.getPassword();


        String email = userDto.getEmail();
        String phone = userDto.getPhone();
        String auth = userDto.getAuth();

        Optional<User> selectedUser = Optional.ofNullable(userRepository.getById(userDto.getId()));




        User user;
        SignUpResultDto signUpResultDto = new SignUpResultDto();


        if(selectedUser.isPresent()){
            if (auth.equalsIgnoreCase("admin")) {
                user = User.builder()

                        .name(name)
                        .password(password)
                        .customer_name(customer_name)
                        .email(email)
                        .phone(phone)

                        .auth(Collections.singletonList("ROLE_ADMIN"))

                        .updated(LocalDateTime.now())
                        .used(Math.toIntExact(userDto.getUsed()))
                        .build();
                userRepository.save(user);
                // UserProduct 저장

                setSuccessResult(signUpResultDto);
                return signUpResultDto;

            } else if(auth.equalsIgnoreCase("user")){
                user = User.builder()

                        .name(name)
                        .password(password)
                        .customer_name(customer_name)
                        .email(email)
                        .phone(phone)

                        .auth(Collections.singletonList("ROLE_USER"))
                        .updated(LocalDateTime.now())
                        .used(Math.toIntExact(userDto.getUsed()))
                        .build();
                userRepository.save(user);






                setSuccessResult(signUpResultDto);
                return signUpResultDto;
            }else{
                throw new RuntimeException();
            }

        }else{
            setFailResult(signUpResultDto);
            return signUpResultDto;


        }

    }

    @Override
    public SignInResultDto signIn(String id,String password,String clientIp) throws RuntimeException{
        LOGGER.info("[getSignInResult] signDateHandler로 회원 정보 요청");
        User user = userRepository.getById(id);
        LOGGER.info("[getSignInResult] Id : {}",user);
        LOGGER.info("[getByID] id: {}",user);

        LOGGER.info("[String clientIp] String clientIp: {}",clientIp);
        LOGGER.info("[getSignInResult] 패스워드 비교 수행 : {}",passwordEncoder.matches(password, user.getPassword()));

        if(user == null || !passwordEncoder.matches(password, user.getPassword()))  {
            SignInResultDto signInResultDto = new SignInResultDto();

            LOGGER.info("[getSignInResult] in : {}",signInResultDto);
            setFailResult(signInResultDto);
            return signInResultDto;
        }else if(user != null && (passwordEncoder.matches(password, user.getPassword()))){
            LOGGER.info("[getSignInResult] 패스워드 일치");
            LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");



            History history = new History();

            history.setName("로그인");
            history.setIp(clientIp);
            history.setUser(user);

            history.setCreated(LocalDateTime.now());

            History insertHistory = historyRepository.save(history);


            SignInResultDto signInResultDto = SignInResultDto.builder()
                    .token(jwtTokenProvider.createToken(String.valueOf(user.getId()),user.getAuth()))
                    .build();

            LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입 lgoger: {}",signInResultDto);
            setSuccessResult(signInResultDto);
            return signInResultDto;
        }else{
            throw new RuntimeException();
        }

    }

    @Override
    public SignInResultDto passwordInit(String code,String phone) throws RuntimeException {
        LOGGER.info("[getSignInResult] signDateHandler로 회원 정보 요청", code, phone);

        LOGGER.info("[getSignInResult] UserCode : {}", code);
        LOGGER.info("[getSignInResult] UserPHone : {}", phone);


        Optional<User> selectedUser = Optional.ofNullable(userRepository.findByCodeAndPhone(code,phone));

        User user;
        SignInResultDto signInResultDto = new SignInResultDto();

        LOGGER.info("[selectedUser] selectedUser : {}", selectedUser);
        if (selectedUser.isPresent()) {
            String init_password = "1111";

            User getUser = selectedUser.get();
            String id = getUser.getId();
            String name = getUser.getName();
            String customer_name = getUser.getCustomer_name();
            String email = getUser.getEmail();



            Car car = getUser.getCar();





            user = User.builder()
                    .name(name)
                    .customer_name(customer_name)
                    .password(passwordEncoder.encode(init_password))
                    .car(car)
                    .id(id)
                    .email(email)
                    .code(code)
                    .phone(phone)
                    .updated(LocalDateTime.now())
                    .used(1)
                    .build();
            userRepository.save(user);


            LOGGER.info("[getSignInResult] 패스워드 일치");
            LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");


            setSuccessResult(signInResultDto);


            return signInResultDto;
        } else {


            LOGGER.info("[getSignInResult] in : {}", signInResultDto);
            setFailResult(signInResultDto);
            return signInResultDto;






        }


    }




    @Override
    public String delete(List<String> ids) throws Exception {

        for (String id : ids) {
            Optional<User> selectedUser = userRepository.findById(id);
            if (selectedUser.isPresent()) {
                User user = selectedUser.get();
                user.setUsed(0);
                user.setDeleted(LocalDateTime.now());
                userRepository.save(user);
            } else {
                throw new Exception("USER with UID " + id + " not found.");
            }
        }
        return "USER deleted successfully";
    }

    private void setSuccessResult(SignUpResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(SignUpResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }



}
