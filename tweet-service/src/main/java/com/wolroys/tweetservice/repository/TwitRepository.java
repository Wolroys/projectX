package com.wolroys.tweetservice.repository;

import com.wolroys.entitymodule.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitRepository extends JpaRepository<Post, Long> {
}
