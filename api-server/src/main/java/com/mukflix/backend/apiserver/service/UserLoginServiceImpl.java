package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.dto.User;
import com.mukflix.backend.apiserver.mapper.UserLoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserLoginServiceImpl implements UserLoginService {

    private UserLoginMapper userLoginMapper;

    @Autowired
    UserLoginServiceImpl(
            UserLoginMapper userLoginMapper
    ) {
        this.userLoginMapper = userLoginMapper;
    }

    @Override
    public List<User> getUserInfo(){
        log.info("service 시작");
        return userLoginMapper.getUserInfo();
    }
}
