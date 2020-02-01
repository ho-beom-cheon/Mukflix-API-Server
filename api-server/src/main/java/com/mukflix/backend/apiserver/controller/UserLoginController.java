package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class UserLoginController {

    private UserLoginService userLoginService;

    @Autowired
    UserLoginController(
        UserLoginService userLoginService
    ){
        this.userLoginService = userLoginService;
    }

    @GetMapping("/userinfo")
    @ResponseBody
    public List<Map<String, Object>> getUserInfo(){
        return userLoginService.getUserInfo();
    }

}
