package com.bootloadr.demo.resolver.ql;

import com.bootloadr.demo.pojo.User;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import com.bootloadr.demo.repository.UserRepository;

@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {
    private final UserRepository userRepository;

    public User user(String username){
        return userRepository.findByusername(username);
    }

}
