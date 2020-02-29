package com.mukflix.backend.apiserver.service.logic;

import com.mukflix.backend.apiserver.dto.User;
import com.mukflix.backend.apiserver.dao.mapper.UserLoginMapper;
import com.mukflix.backend.apiserver.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        return userLoginMapper.getUserInfo();
    }
}
