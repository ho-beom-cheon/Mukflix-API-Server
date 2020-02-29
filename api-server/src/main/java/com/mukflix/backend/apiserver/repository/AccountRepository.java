package com.mukflix.backend.apiserver.repository;

import com.mukflix.backend.apiserver.dto.Account;
import com.mukflix.backend.apiserver.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    AccountMapper accountMapper;

    public Account save(Account account, String role){
        accountMapper.insertUser(account);
        accountMapper.insertUserAutority(account.getUsername(),role);
        return account;
    }

    public Account findById(String username){
        return accountMapper.readAccount(username);
    }

    public List<String> findAuthoritiesByID(String username){
        return accountMapper.readAutorities(username);
    }
}
