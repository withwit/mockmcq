package com.mockmcq.mockmcq.service;

import com.mockmcq.mockmcq.entity.Answer;
import com.mockmcq.mockmcq.entity.Question;
import com.mockmcq.mockmcq.entity.Session;
import com.mockmcq.mockmcq.repository.AnswerRepository;
import com.mockmcq.mockmcq.repository.QuestionRepository;
import com.mockmcq.mockmcq.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private AnswerRepository userAnswerRepository;

    //This creates a new session for each user
    public Session startNewSession(String username) {
        Session session = new Session();
        session.setUsername(username);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        session.setTotalAnswered(0);
        System.out.println(session.toString());
        return quizSessionRepository.save(session);
    }

    //This returns a random question from Question table.
    public Question getRandomQuestion() {
        return questionRepository.findRandom()
                .orElseThrow(() -> new RuntimeException("No questions available"));
    }

    //This submits the answer and records the response of that answer in Session table
    public void submitAnswer(Long sessionId, Long questionId, String answer) {
        Session session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean isCorrect = question.getCorrectAnswer().equals(answer);

        Answer userAnswer = new Answer();
        userAnswer.setSession(session);
        userAnswer.setQuestionId(questionId);
        userAnswer.setUserAnswer(answer);
        userAnswer.setCorrect(isCorrect);

        userAnswerRepository.save(userAnswer);

        session.setTotalAnswered(session.getTotalAnswered() + 1);
        if (isCorrect) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        quizSessionRepository.save(session);
    }

    //This returns the total details of the user by username
    public Session getSessionStatus(String username) {
        return quizSessionRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

}
