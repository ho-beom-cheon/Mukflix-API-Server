package com.mukflix.backend.apiserver.service.logic;

import com.mukflix.backend.apiserver.dao.repository.FeedRepository;
import com.mukflix.backend.apiserver.dto.Feed;
import com.mukflix.backend.apiserver.service.FeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FeedServiceImpl implements FeedService {

    @Autowired
    FeedRepository feedRepository;

    @Override
    public Boolean createFeed(Feed feed) {
        return null;
    }

    @Override
    public Feed getFeed(String userId, String feedId) {
        return null;
    }

    @Override
    public Boolean updateFeed(String userId, Feed feed) {
        return null;
    }

    @Override
    public Boolean deleteFeed(String userId, String feedId) {
        return null;
    }
}
