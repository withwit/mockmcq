package com.mockmcq.mockmcq.controller;

import com.mockmcq.mockmcq.entity.Question;
import com.mockmcq.mockmcq.entity.Session;
import com.mockmcq.mockmcq.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Start a new quiz session
    @PostMapping("/start")
    public Session startQuiz(@RequestParam String username) {
        return quizService.startNewSession(username);
    }

    // Get a random question
    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    // Submit an answer
    @PostMapping("/answer")
    public ResponseEntity<String> submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String answer) {

        quizService.submitAnswer(sessionId, questionId, answer);
        return ResponseEntity.ok("Answer submitted successfully");
    }

    // Get session status (correct/incorrect count)
    @GetMapping("/status")
    public Session getSessionStatus(@RequestParam String username) {
        return quizService.getSessionStatus(username);
    }
}
