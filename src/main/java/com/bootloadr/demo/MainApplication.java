package com.bootloadr.demo;

import com.bootloadr.demo.repository.TweetRepository;
import com.bootloadr.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.bootloadr.demo.repository.*;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Bean
	@Autowired
	public ServletRegistrationBean graphQLServlet(UserRepository userRepository, TweetRepository tweetRepository, TagRepository tagRepository) {
		return new ServletRegistrationBean(new GraphQLEntryPoint(userRepository, tweetRepository,tagRepository),"/graphql");
	}

}
