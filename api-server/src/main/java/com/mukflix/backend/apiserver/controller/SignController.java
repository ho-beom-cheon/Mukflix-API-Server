package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.configuration.advice.exception.CEmailSigninFailedException;
import com.mukflix.backend.apiserver.configuration.config.security.JwtTokenProvider;
import com.mukflix.backend.apiserver.dao.repository.UserJpaRepository;
import com.mukflix.backend.apiserver.dto.CommonResult;
import com.mukflix.backend.apiserver.dto.PasswordChangeRecord;
import com.mukflix.backend.apiserver.dto.SingleResult;
import com.mukflix.backend.apiserver.dto.User;
import com.mukflix.backend.apiserver.service.logic.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@Slf4j
@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserJpaRepository userJpaRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String email,
                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {

        User user = userJpaRepository.findByUserEmail(email).orElseThrow(CEmailSigninFailedException::new);

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new CEmailSigninFailedException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getUserSequence()), user.getRoles()));
    }


    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public CommonResult signup(@ApiParam(value = "회원ID : 이메일", required = true) @Valid @RequestParam String email,
                               @ApiParam(value = "비밀번호", required = true) @Valid @RequestParam String password,
                               @ApiParam(value = "이름", required = false) @RequestParam String name,
                               @ApiParam(value = "생일", required = false) @RequestParam String birth,
                               @ApiParam(value = "성별", required = false) @RequestParam String gend
                               ){

        PasswordChangeRecord passwordChangeRecord = new PasswordChangeRecord();
        passwordChangeRecord.setPassword(passwordEncoder.encode(password));

        userJpaRepository.save(User.builder()
                .userEmail(email)
                .passwordChangeRecord(passwordChangeRecord)
                .userName(name)
                .userBirth(birth)
                .userGender(gend)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());



        return responseService.getSuccessResult();
    }

}