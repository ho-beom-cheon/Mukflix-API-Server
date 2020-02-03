package com.mukflix.backend.apiserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserLoginMapper {
    List<Map<String, Object>> getUserInfo();
}
