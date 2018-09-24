package com.daiql.jpapage.repository;

import com.daiql.jpapage.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByUsername(String username, Pageable pageable);
}
