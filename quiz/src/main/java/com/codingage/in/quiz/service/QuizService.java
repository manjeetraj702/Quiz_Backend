package com.codingage.in.quiz.service;

import com.codingage.in.quiz.model.Quiz;
import com.codingage.in.quiz.model.request.CreateQuiz;
import com.codingage.in.quiz.model.request.UpdateQuiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    Quiz createQuiz(String userId, CreateQuiz createQuiz);

    Quiz updateQuiz(String userId, UpdateQuiz updateQuiz);

    Quiz getQuizById(String userId, String quizId);

    Quiz getQuizById(String quizId);

    Boolean deleteQuiz(String userId, String quizId);

    List<Quiz> getAllQuiz();
}
