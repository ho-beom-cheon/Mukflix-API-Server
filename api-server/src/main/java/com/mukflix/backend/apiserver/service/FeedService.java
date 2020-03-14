package com.mukflix.backend.apiserver.service;

import com.mukflix.backend.apiserver.dto.Feed;

/**
 * @author hslee
 * @since 2020.03.14
 */
public interface FeedService {

    /**
     * 기록 생성
     *
     * @param feed
     * @return
     */
    Boolean createFeed(Feed feed);

    /**
     * 기록 조회
     *
     * @param userId
     * @param feedId
     * @return
     */
    Feed getFeed(String userId, String feedId);

    /**
     * 기록 수정
     *
     * @param userId
     * @param feed
     * @return
     */
    Boolean updateFeed(String userId, Feed feed);

    /**
     * 기록 삭제
     *
     * @param userId
     * @param feedId
     * @return
     */
    Boolean deleteFeed(String userId, String feedId);

}
