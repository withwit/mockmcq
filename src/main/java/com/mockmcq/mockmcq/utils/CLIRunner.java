package com.mockmcq.mockmcq.utils;


import com.mockmcq.mockmcq.entity.Question;
import com.mockmcq.mockmcq.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CLIRunner implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    public CLIRunner(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Define some random questions
        Question q1 = new Question();
        q1.setQuestionText("What is the capital of Japan?");
        q1.setOptions(Arrays.asList("Beijing", "Seoul", "Tokyo", "Bangkok"));
        q1.setCorrectAnswer("Tokyo");

        Question q2 = new Question();
        q2.setQuestionText("What is 3 + 5?");
        q2.setOptions(Arrays.asList("6", "8", "10", "7"));
        q2.setCorrectAnswer("8");

        Question q3 = new Question();
        q3.setQuestionText("Which planet is known as the Red Planet?");
        q3.setOptions(Arrays.asList("Earth", "Mars", "Jupiter", "Venus"));
        q3.setCorrectAnswer("Mars");

        Question q4 = new Question();
        q4.setQuestionText("What is the largest ocean on Earth?");
        q4.setOptions(Arrays.asList("Atlantic", "Indian", "Arctic", "Pacific"));
        q4.setCorrectAnswer("Pacific");

        Question q5 = new Question();
        q5.setQuestionText("What is the chemical symbol for Gold?");
        q5.setOptions(Arrays.asList("Au", "Ag", "Pb", "Fe"));
        q5.setCorrectAnswer("Au");

        // Save questions to the database
        questionRepository.saveAll(Arrays.asList(q1, q2, q3, q4, q5));
    }
}
