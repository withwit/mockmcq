package com.mockmcq.mockmcq.repository;

import com.mockmcq.mockmcq.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q ORDER BY FUNCTION('RAND') LIMIT 1")
    Optional<Question> findRandom();
}