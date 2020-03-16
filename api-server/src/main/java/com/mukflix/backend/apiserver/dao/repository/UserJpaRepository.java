package com.mukflix.backend.apiserver.dao.repository;

import com.mukflix.backend.apiserver.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {


}