package com.springboot.java_jangan.service;

import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.dto.user.UserDto;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.User;

import java.util.List;

public interface SignService {


    SignUpResultDto save(UserDto userDto);

    SignUpResultDto update(UserDto userDto);

    SignUpResultDto mobileUpdate(UserDto userDto);

    List<User> getTotalUser(UserSearchDto userSearchDto);
    List<User> getUser(UserSearchDto userSearchDto);

    String delete(List<String> id) throws Exception;
    SignInResultDto signIn(String userId, String password,String clientIp) throws RuntimeException;
    SignInResultDto mobileSignIn(String userId, String password,String clientIp) throws RuntimeException;

    SignInResultDto passwordInit(String code, String phone) throws RuntimeException;


}
