package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dao.repository.UserJpaRepo;
import com.mukflix.backend.apiserver.dto.*;
import com.mukflix.backend.apiserver.service.logic.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/function")
public class UserController {

    private final UserJpaRepo userJpaRepo;
    private final ResponseService responseService;


    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userJpaRepo.findAll());
    }



    @ApiOperation(value = "회원 단건 조회", notes = "userId로 회원을 조회한다")
    @GetMapping(value = "/user/{sq}")
    public SingleResult<User> findUserByEmail(@ApiParam(value = "회원ID", required = true) @PathVariable Long sq) {
        return responseService.getSingleResult(userJpaRepo.findById(sq).orElse(null));
    }



    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다")
    @PostMapping(value = "/user")
    public SingleResult<User> save(
                                    @ApiParam(value = "회원이메일", required = true) @RequestParam String email,
                                    @ApiParam(value = "회원이메일", required = true) @RequestParam String passWord,
                                    @ApiParam(value = "회원이름", required = true) @RequestParam String name,
                                    @ApiParam(value = "회원생일", required = true) @RequestParam String birth,
                                    @ApiParam(value = "회원성별", required = true) @RequestParam String gend)
    {
        PassWord passWord1 = new PassWord();
        passWord1.setPw(passWord);
        User user = User.builder()
                .passWord(passWord1)
                .email(email)
                .name(name)
                .birth(birth)
                .gend(gend)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }


    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다")
    @PutMapping(value = "/user")
    public SingleResult<User> modify(
            @ApiParam(value = "회원번호", required = true) @RequestParam Long sq,
            @ApiParam(value = "회원이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .USR_SQ(sq)
                .email(email)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }



    @ApiOperation(value = "회원 삭제", notes = "userId로 회원정보를 삭제한다")
    @DeleteMapping(value = "/user/{sq}")
    public CommonResult delete(
            @ApiParam(value = "회원번호", required = true) @PathVariable Long sq) {
        userJpaRepo.deleteById(sq);
        return responseService.getSuccessResult();
    }
}