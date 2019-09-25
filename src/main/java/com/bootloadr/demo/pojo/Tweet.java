package com.bootloadr.demo.pojo;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tweet")
public class Tweet {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private Integer id;
    @Column(name = "text", nullable = false)
    private String text;
    @ManyToOne(fetch=FetchType.EAGER)
    private User author;
    @ManyToOne(fetch=FetchType.EAGER)
    private Tag hash_tag;

    public Tweet(){}

    public Tweet(String text, User user){
        this.text = text;
        this.author = user;
    }

}
