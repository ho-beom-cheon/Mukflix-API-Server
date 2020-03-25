package com.mukflix.backend.apiserver.dao.repository;

import com.mukflix.backend.apiserver.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    //회원 가입 시 가입한 이메일 조회를 위한 메소드
    Optional<User> findByUserEmail(String email);
}
