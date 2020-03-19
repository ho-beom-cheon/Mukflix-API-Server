package com.mukflix.backend.apiserver.service.logic;

import com.mukflix.backend.apiserver.configuration.advice.exception.CUserNotFoundException;
import com.mukflix.backend.apiserver.dao.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public UserDetails loadUserByUsername(String username){
        return userJpaRepository.findById(Long.valueOf(username)).orElseThrow(CUserNotFoundException::new);
    }
}
