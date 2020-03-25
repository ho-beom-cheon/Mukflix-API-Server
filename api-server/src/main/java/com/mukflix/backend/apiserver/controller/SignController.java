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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@Slf4j
@Api(tags = {"1. MUK_SIGN"})
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
    public CommonResult signup(@RequestBody User user){

        PasswordChangeRecord passwordChangeRecord = new PasswordChangeRecord();
        passwordChangeRecord.setPassword(passwordEncoder.encode(user.getPassword()));

        userJpaRepository.save(User.builder()
                .userEmail(user.getUserEmail())
                .passwordChangeRecord(passwordChangeRecord)
                .userName(user.getUsername())
                .userBirth(user.getUserBirth())
                .userGender(user.getUserGender())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());



        return responseService.getSuccessResult();
    }

}