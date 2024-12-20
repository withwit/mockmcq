package com.mockmcq.mockmcq.repository;

import com.mockmcq.mockmcq.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizSessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByUsername(String username);
}
