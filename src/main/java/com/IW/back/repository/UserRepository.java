package com.IW.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IW.back.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmail(String email);
    User findByEmail(String email);

    List<User> findByType(String type);
}

