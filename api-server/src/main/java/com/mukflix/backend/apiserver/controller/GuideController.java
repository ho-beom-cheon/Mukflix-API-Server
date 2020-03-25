package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dao.repository.GuideRepository;
import com.mukflix.backend.apiserver.dao.repository.UserJpaRepository;
import com.mukflix.backend.apiserver.dto.Guide;
import com.mukflix.backend.apiserver.dto.ListResult;
import com.mukflix.backend.apiserver.dto.User;
import com.mukflix.backend.apiserver.service.GuideService;
import com.mukflix.backend.apiserver.service.logic.ResponseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 * Mapping 규칙
 * 1. 명사일것
 * 2. 대문자 사용 불가
 * 3. 대문자 필요시 "-" 사용 (mukflix-guide)
 * */
@RestController
@RequiredArgsConstructor // final 상수를 선언하기위한 어노테이션
@RequestMapping("/guide") // EndPoint 지점 (요청에 대한 노출부)
public class GuideController {

    private final GuideRepository guideRepository;
    private final ResponseService responseService; // 결과를 처리할 Service

    @Autowired // 구현체의 Annotation 에 연결됨
    private GuideService guideService;

    @GetMapping
    public List<Guide> getGuideList() {
        return guideService.getGuideList();
    }


    @GetMapping("/message")
    public ListResult<Guide> findAllUser() {
        return responseService.getListResult(guideRepository.findAll());
    }

    @PostMapping
    public Guide createGuide(@RequestBody Guide guide) {
        return guideService.createGuide(guide);
    }

    @PutMapping("{id}/{name}")
    public Guide updateGuideName(@PathVariable(name = "id") String id,
                                 @PathVariable(name = "name") String name) {
        return guideService.updateGuideName(id, name);
    }

    @DeleteMapping("{id}")
    public Boolean deleteGuide(@PathVariable(name = "id") String id) {
        return guideService.deleteGuide(id);
    }


}
