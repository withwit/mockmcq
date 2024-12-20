package com.mockmcq.mockmcq.repository;

import com.mockmcq.mockmcq.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
