package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dto.Guide;
import com.mukflix.backend.apiserver.service.GuideService;
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
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping
    public List<Guide> getGuideList() {
        return guideService.getGuideList();
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
