package com.bootloadr.demo.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Integer id;
    @Column(name = "text", nullable = false, unique = true, length = 60)
    private String text;
    @OneToMany(mappedBy="hash_tag",fetch = FetchType.EAGER)
    private List<Tweet> tweets = new ArrayList<>();
}
