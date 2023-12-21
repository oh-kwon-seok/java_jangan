package com.springboot.java_jangan.authentication.application;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.authentication.domain.AuthTokens;
import com.springboot.java_jangan.authentication.infra.kakao.KakaoLoginParams;
import com.springboot.java_jangan.authentication.infra.naver.NaverLoginParams;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Controller
public class AuthController {
    private final OAuthLoginService oAuthLoginService;


    @Autowired
    public AuthController(OAuthLoginService oAuthLoginService) {
        this.oAuthLoginService = oAuthLoginService;
    }

    @PostMapping(value="/kakao", consumes="application/json", produces = "application/json")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) throws Exception{

        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

    @PostMapping(value="/naver", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthTokens> loginNaver(@RequestBody NaverLoginParams params) throws Exception{
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}