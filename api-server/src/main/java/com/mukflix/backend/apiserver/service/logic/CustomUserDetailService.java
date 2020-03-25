package com.mukflix.backend.apiserver.service.logic;

import com.mukflix.backend.apiserver.configuration.advice.exception.CUserNotFoundException;
import com.mukflix.backend.apiserver.dao.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * UserDetails
 *
 * 1. Spring Security에서 사용자의 정보를 담는 인터페이스.
 * 2. 인터페이스 구현 시 Spring Security에서 구현한 클래스를
 *    사용자 정보로 인식하고 인증 작업을 한다.
 */


@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    //DB에서 유정 정보를 불러오는 메소드
    public UserDetails loadUserByUsername(String username){
        return userJpaRepository.findById(Long.valueOf(username)).orElseThrow(CUserNotFoundException::new);
    }
}


//참고 링크 : https://to-dy.tistory.com/86