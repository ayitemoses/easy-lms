package com.akadev.lms_backend.repository;

import com.akadev.lms_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
