package com.wolroys.tweetservice.repository;

import com.wolroys.entitymodule.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitRepository extends JpaRepository<Post, Long> {

    @Query("SELECT DISTINCT p from Post p JOIN p.hashtags h WHERE h.name IN :hashtags")
    List<Post> findByHashtags(List<String> hashtags);
}
