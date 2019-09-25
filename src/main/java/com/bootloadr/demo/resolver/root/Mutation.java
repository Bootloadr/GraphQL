package com.bootloadr.demo.resolver.root;


import com.bootloadr.demo.pojo.Tag;
import com.bootloadr.demo.pojo.Tweet;
import com.bootloadr.demo.pojo.User;
import com.bootloadr.demo.repository.TagRepository;
import com.bootloadr.demo.repository.TweetRepository;
import com.bootloadr.demo.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RequiredArgsConstructor
public class Mutation implements GraphQLRootResolver {

	private final UserRepository userRepository;
	private final TweetRepository tweetRepository;
	private final TagRepository tagRepository;

	public Tweet tweet(String text, int userId){
			User user = userRepository.findById(userId).get();
			if(user != null){
				Tweet tweet = new Tweet(text,user);

				Pattern pattern = Pattern.compile("#\\w+");

				Matcher matcher = pattern.matcher(text);
				if(matcher.find()) {
					String hashtag = matcher.group();
					Tag tag = tagRepository.findByText(hashtag);
					if(tag == null){
						Tag t = new Tag();
						t.setText(hashtag);
						tag = tagRepository.save(t);
					}
					tweet.setHash_tag(tag);
				}
				return  tweetRepository.save(tweet);
			}
			else
				return null;

	}

	public User newAuthor(String name, String username){
		User user = userRepository.findByusername(username);
		if(user == null){
			user = new User();
			user.setName(name);
			user.setUsername(username);

			return userRepository.save(user);
		}
		else return null;
	}

}
