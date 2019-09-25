package com.bootloadr.demo.resolver.ql;

import com.bootloadr.demo.pojo.Tweet;
import com.bootloadr.demo.repository.TweetRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TweetResolver implements GraphQLResolver<Tweet> {
    private final TweetRepository tweetRepository;

    public List<Tweet> tweets(){
        return tweetRepository.findAll();
    }
}
