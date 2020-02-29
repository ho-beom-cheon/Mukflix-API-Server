package com.mukflix.backend.apiserver.dao.mapper;

import com.mukflix.backend.apiserver.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserLoginMapper {
    List<User> getUserInfo();
}