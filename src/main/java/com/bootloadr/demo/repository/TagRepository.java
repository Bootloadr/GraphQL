package com.bootloadr.demo.repository;

import com.bootloadr.demo.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query("SELECT a FROM Tag a LEFT JOIN a.tweets t WHERE a.id = t.hash_tag AND a.text = ?1")
    public Tag findBytagname(String tagname);

    public Tag findByText(String text);
}
