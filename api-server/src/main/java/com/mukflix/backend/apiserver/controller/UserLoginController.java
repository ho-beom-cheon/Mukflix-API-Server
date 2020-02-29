package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dto.User;
import com.mukflix.backend.apiserver.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/login")
public class UserLoginController {

    private UserLoginService userLoginService;

    @Autowired
    UserLoginController(
            UserLoginService userLoginService
    ) {
        this.userLoginService = userLoginService;
    }

    @RequestMapping("/userinfo")
    public List<User> getUserInfo() throws Exception {
        return userLoginService.getUserInfo();
    }
}
