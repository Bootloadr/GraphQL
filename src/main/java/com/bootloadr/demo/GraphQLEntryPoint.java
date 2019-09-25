package com.bootloadr.demo;

import com.bootloadr.demo.repository.TagRepository;
import com.bootloadr.demo.repository.TweetRepository;
import com.bootloadr.demo.repository.UserRepository;
import com.bootloadr.demo.resolver.ql.TagResolver;
import com.bootloadr.demo.resolver.ql.TweetResolver;
import com.bootloadr.demo.resolver.ql.UserResolver;
import com.bootloadr.demo.resolver.root.Mutation;
import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import com.bootloadr.demo.resolver.root.Query;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(UserRepository userRepository, TweetRepository tweetRepository, TagRepository tagRepository) {
		super(buildSchema(userRepository,tweetRepository, tagRepository));
	}

	private static GraphQLSchema buildSchema(UserRepository userRepository, TweetRepository tweetRepository, TagRepository tagRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(userRepository,tweetRepository,tagRepository),
						new Mutation(userRepository,tweetRepository,tagRepository),
						new TweetResolver(tweetRepository),
						new UserResolver(userRepository),
						new TagResolver(tagRepository))
				.build()
				.makeExecutableSchema();
	}	

}
