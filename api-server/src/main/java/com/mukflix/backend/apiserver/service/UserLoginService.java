package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.dto.User;

import java.util.List;

public interface UserLoginService {

    List<User> getUserInfo() throws Exception;
}
