package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    private UserLoginMapper userLoginMapper;

    @Autowired
    UserLoginServiceImpl(
            UserLoginMapper userLoginMapper
    ) {
        this.userLoginMapper = userLoginMapper;
    }

    public List<Map<String, Object>> getUserInfo(){
        return userLoginMapper.getUserInfo();
    }

}
