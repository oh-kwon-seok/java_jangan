package com.springboot.java_jangan.data.repository.User;

import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.User;

import java.util.List;

public interface UserRepositoryCustom {



    List<User> findAll(UserSearchDto userSearchDto);
    List<User> findInfo(UserSearchDto userSearchDto);



}
