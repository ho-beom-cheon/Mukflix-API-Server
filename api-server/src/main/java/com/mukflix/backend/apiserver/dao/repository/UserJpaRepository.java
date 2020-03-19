package com.mukflix.backend.apiserver.dao.repository;

import com.mukflix.backend.apiserver.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String email);
}
