package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.dto.TestDto;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestDto test(TestDto t){
        TestDto testDto = new TestDto();
        return testDto;
    }
}
