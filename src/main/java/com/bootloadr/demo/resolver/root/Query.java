package com.bootloadr.demo.resolver.root;

import com.bootloadr.demo.pojo.Tag;
import com.bootloadr.demo.pojo.Tweet;
import com.bootloadr.demo.pojo.User;
import com.bootloadr.demo.repository.TagRepository;
import com.bootloadr.demo.repository.TweetRepository;
import com.bootloadr.demo.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLRootResolver {
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final TagRepository tagRepository;


    public List<Tweet> tweets(){

        return tweetRepository.findAll();
    }


    public User user(String username){
        User user = userRepository.findByusername(username);

        return user;
    }

    public List<Tweet> findbytag(String tagname){
        Tag tag =  tagRepository.findByText(tagname);
        if(tag != null)
            return tag.getTweets();
        else
            return null;
    }
}
