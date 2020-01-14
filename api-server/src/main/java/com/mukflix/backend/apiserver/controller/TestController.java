package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dto.TestDto;
import com.mukflix.backend.apiserver.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                  /*restful 형식으로 기본적으로 return이 json으로 됨 */
@RequestMapping(value = "/test") /* class 호출방식 */
@Slf4j                           /* log사용 */
public class TestController {

/*
1. 아래 어노테이션 파악해서 사용
@Autowired
@Override
@Resource

2. [service -> dao -> sql] 테스트 소스 구현
*/

    @RequestMapping(value = "/hello")
    public TestDto test(@RequestParam("name") String name
                        , @RequestParam("ment") String ment) {

        //log.
        log.info("*************************hello it's Mukflix!*************************");
        log.info("*************************hello it's Mukflix!*************************");
        log.info("test 시작");
        log.info("");
        log.info("");

        /* start */
        TestDto testDto = new TestDto();
        testDto.setName(name);
        testDto.setMention(ment);

        TestService testService = new TestService();
        TestDto rtntestDto = testService.test(testDto);
        /* end */
        
        log.info("name : " + name);
        log.info("ment : " + ment);
        log.info("");
        log.info("");
        log.info("test 종료");
        log.info("*************************bye it's Mukflix!*************************");
        log.info("*************************bye it's Mukflix!*************************");

        return testDto;
    }
}