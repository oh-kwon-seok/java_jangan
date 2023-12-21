package com.springboot.java_jangan.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dao.UserDAO;

import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.*;
import com.springboot.java_jangan.data.repository.User.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserDAOImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> selectTotalUser(UserSearchDto userSearchDto) {
        return userRepository.findAll(userSearchDto);
    }
    public List<User> selectUser(UserSearchDto userSearchDto) {
        return userRepository.findInfo(userSearchDto);
    }
}

