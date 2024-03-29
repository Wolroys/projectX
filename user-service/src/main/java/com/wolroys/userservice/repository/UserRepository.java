package com.wolroys.userservice.repository;

import com.wolroys.entitymodule.entity.Post;
import com.wolroys.entitymodule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
