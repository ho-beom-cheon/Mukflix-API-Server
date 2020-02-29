package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dto.Account;
import com.mukflix.backend.apiserver.mapper.AccountMapper;
import com.mukflix.backend.apiserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    //ADMIN 계정부여
    @GetMapping("/create")
    public Account create(){
        Account account = new Account();
        account.setId("admin");
        account.setPassword("1234");
        accountService.save(account, "ROLE_ADMIN");
        return account;
    }
}
