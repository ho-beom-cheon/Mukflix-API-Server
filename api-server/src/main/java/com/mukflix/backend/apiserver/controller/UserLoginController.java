package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dto.User;
import com.mukflix.backend.apiserver.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class UserLoginController {

    private UserLoginService userLoginService;

    @Autowired
    UserLoginController(
        UserLoginService userLoginService
    ){
        this.userLoginService = userLoginService;
    }

    @RequestMapping("/userinfo")
    public List<User> getUserInfo() throws Exception{
        log.info("controller 시작");
        return userLoginService.getUserInfo();
    }
}
