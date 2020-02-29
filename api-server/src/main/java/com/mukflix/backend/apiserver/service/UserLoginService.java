package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.dto.User;

import java.util.List;



/*
    - 인터페이스는 내부에 메소드 본체를 가질 수 없다.
      필요한 메소드 헤더만 정의하고 이를 구현하는 클래스에서 본체를 구현할 수 있다.
    - 인터페이스로 구성 시 장점 => 확장성, 유연성
*/

public interface UserLoginService {

    List<User> getUserInfo() throws Exception;

}
