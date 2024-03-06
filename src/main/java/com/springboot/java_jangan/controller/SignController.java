package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.dto.user.UserDto;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.Car;
import com.springboot.java_jangan.data.entity.Product;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.service.SignService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController


@RequestMapping("/user")
public class SignController {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService){
        this.signService = signService;
    }



    @GetMapping(value= "/select")
    public ResponseEntity<List<User>> getTotalUser(@ModelAttribute UserSearchDto userSearchDto) throws RuntimeException{
        long currentTime = System.currentTimeMillis();

        List<User> selectedTotalUser = signService.getTotalUser(userSearchDto);

        LOGGER.info("[getTotalUser] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUser);
    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<User>> getUser(@ModelAttribute UserSearchDto userSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<User> selectedTotalUser = signService.getUser(userSearchDto);

        LOGGER.info("[getTotalUser] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUser);

    }




    @PostMapping(value= "/save",consumes = "application/json", produces = "application/json")
    public SignUpResultDto save(@RequestBody UserDto userDto) throws RuntimeException {
        long currentTime = System.currentTimeMillis();

        SignUpResultDto signUpResultDto = signService.save(userDto);

        return signUpResultDto;
    }

    @PostMapping(value= "/update",consumes = "application/json", produces = "application/json")
    public SignUpResultDto update(@RequestBody UserDto userDto) throws RuntimeException {
        long currentTime = System.currentTimeMillis();

        SignUpResultDto signUpResultDto = signService.update(userDto);

        return signUpResultDto;
    }

    @PostMapping(value= "/mobile_update",consumes = "application/json", produces = "application/json")
    public SignUpResultDto mobileUpdate(@RequestBody UserDto userDto) throws RuntimeException {
        long currentTime = System.currentTimeMillis();

        SignUpResultDto signUpResultDto = signService.mobileUpdate(userDto);

        return signUpResultDto;
    }

    @PostMapping(value= "/sign-in", consumes = "application/json", produces = "application/json")
    public SignInResultDto signIn(
            @RequestBody User user, HttpServletRequest request
            ) throws RuntimeException {

        LOGGER.info("[signIn] 로그인을 시도하고 있습니다.id: {}, pw: ****", user.getId());
        LOGGER.info("[IP정보] 로그인을 시도하고 있습니다.IP: {}", request.getRemoteAddr());

        SignInResultDto signInResultDto = signService.signIn(user.getId(), user.getPassword(),request.getRemoteAddr());
        if(signInResultDto.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다.id: {}, token : {}",user.getId(), signInResultDto.getToken());
        }
        return signInResultDto;
    }
    @PostMapping(value= "/mobile-signin", consumes = "application/json", produces = "application/json")
    public SignInResultDto mobileSignIn(
            @RequestBody User user, HttpServletRequest request
    ) throws RuntimeException {

        LOGGER.info("[signIn] 모바일로그인을 시도하고 있습니다.id: {}, pw: ****", user.getId());
        LOGGER.info("[IP정보] 모바일로그인을 시도하고 있습니다.IP: {}", request.getRemoteAddr());

        SignInResultDto signInResultDto = signService.mobileSignIn(user.getId(), user.getPassword(),request.getRemoteAddr());
        if(signInResultDto.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다.id: {}, token : {}",user.getId(), signInResultDto.getToken());
        }
        return signInResultDto;
    }




    @PostMapping(value= "/password_init", consumes = "application/json", produces = "application/json")
    public SignInResultDto passwordInit(
            @RequestBody UserDto userDto
    ) throws RuntimeException {

        LOGGER.info("[passwordInit] 패스워드 초기화요청을 실행하고 있습니다.{},{}", userDto.getCode(),userDto.getPhone());
        SignInResultDto signInResultDto = signService.passwordInit(userDto.getCode(), userDto.getPhone());
        if(signInResultDto.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 패스워드 초기화 요청이 실행됐습니다. id: {}, token : {}",userDto.getId(), signInResultDto.getToken());
        }
        return signInResultDto;
    }





    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> delete(@RequestBody Map<String, List<String>> requestMap) throws Exception {
        List<String> id = requestMap.get("id");
        signService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }



    @GetMapping(value= "/exception")
    public void exceptionTest() throws RuntimeException {
        throw new RuntimeException("접근이 금지되었습니다.");

    }


    @ExceptionHandler(value= RuntimeException.class)
    public ResponseEntity<Map<String,String>>  ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "appication/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.error("ExceptionHandler 호출,{},{}", e.getCause(),e.getMessage());
        Map<String,String> map = new HashMap<>();
        map.put("error type",httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message","에러 발생");

        return new ResponseEntity<>(map,responseHeaders,httpStatus);

    }


}
