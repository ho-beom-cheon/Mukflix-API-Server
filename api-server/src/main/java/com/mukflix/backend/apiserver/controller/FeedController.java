package com.mukflix.backend.apiserver.controller;

import com.mukflix.backend.apiserver.dto.Feed;
import com.mukflix.backend.apiserver.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed")
public class FeedController {
    @Autowired
    private FeedService feedService;

    // GET Feed
    @GetMapping
    public Feed getFeed(){
        return null;
    }

    // POST Feed
    @PostMapping
    public Boolean createFeed(@RequestBody Feed feed) {
        return null;
    }

    // DEL Feed
    @DeleteMapping("/{userId}/{feedId}")
    public Boolean deleteFeed(@PathVariable(name = "userId") String userId,
                              @PathVariable(name = "feedId") String feedId){
        return null;
    }

    // PUT Feed
    @PutMapping("{feedId}")
    public Boolean putFeed(@PathVariable() String feedId,
                           @RequestBody Feed feed){
        return null;
    }
}
