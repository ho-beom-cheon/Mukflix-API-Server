package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.dto.Guide;
import java.util.List;

/**
 * Ctrl+Alt+L : 자동 정리
 * Ctrl+Alt+O : Import 정리
 * Alt+Enter: 오류 자동 인지
 */

public interface GuideService {

    /**
     * 가이드 목록 조회
     *
     * @return List<Guide>
     * @author cheon ho beom
     * @since 2020.02.29
     */
    List<Guide> getGuideList();

    /**
     * 가이드 생성
     *
     * @param guide
     * @return Guide
     */
    Guide createGuide(Guide guide);

    /**
     * 가이드 수정
     * 수정 로직에 대해서는 추후 상의 필요
     *
     * @param id
     * @param name
     * @return Guide
     */
    Guide updateGuideName(String id, String name);

    /**
     * 가이드 삭제
     *
     * @param id
     * @return 가이드 삭제 여부
     */
    Boolean deleteGuide(String id);

}
