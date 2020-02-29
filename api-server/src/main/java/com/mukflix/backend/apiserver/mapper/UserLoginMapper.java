package com.mukflix.backend.apiserver.mapper;

import com.mukflix.backend.apiserver.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserLoginMapper {
    List<User> getUserInfo();
}