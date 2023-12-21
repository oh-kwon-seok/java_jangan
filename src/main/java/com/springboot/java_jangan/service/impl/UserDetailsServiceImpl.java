package com.springboot.java_jangan.service.impl;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        LOGGER.info("[loadUserByUsername] loadUserByUsername 수행, username:{}",username);
        return userRepository.getById(username);


    }

}
