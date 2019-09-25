package com.bootloadr.demo.resolver.ql;


import com.bootloadr.demo.pojo.Tag;
import com.bootloadr.demo.pojo.Tweet;
import com.bootloadr.demo.repository.TagRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TagResolver implements GraphQLResolver<Tag> {
    private final TagRepository tagRepository;
    public List<Tweet> findbytag(String tagname){
        Tag tag =  tagRepository.findByText(tagname);
        if(tag != null)
            return tag.getTweets();
        else
            return null;
    }
}
