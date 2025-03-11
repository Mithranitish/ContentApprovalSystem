package com.content.approval.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.approval.system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
