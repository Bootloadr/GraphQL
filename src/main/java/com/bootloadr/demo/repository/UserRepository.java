package com.bootloadr.demo.repository;

import com.bootloadr.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u LEFT JOIN u.tweets t WHERE u.id = t.author AND u.username = ?1")
    public User findByusername(String username);
}
