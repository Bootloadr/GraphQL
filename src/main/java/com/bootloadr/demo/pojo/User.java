package com.bootloadr.demo.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "username", unique = true, length = 50, nullable = false)
    private String username;
    @OneToMany(mappedBy="author",fetch = FetchType.EAGER)
    private  List<Tweet> tweets = new ArrayList<>();
}
