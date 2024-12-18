package com.codingage.in.quiz.service;

import com.codingage.in.quiz.model.Quiz;
import com.codingage.in.quiz.model.request.CreateQuiz;
import com.codingage.in.quiz.model.request.UpdateQuiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    Quiz createQuiz(CreateQuiz createQuiz);

    Quiz updateQuiz(UpdateQuiz updateQuiz);

    Quiz getQuizById(String userId, String quizId);

    Quiz getQuizById(String quizId);

    Boolean deleteQuiz(String adminId, String quizId);

    List<Quiz> getAllQuiz();

    List<Quiz> getAllActiveQuiz();

    List<Quiz> getAllQuizByAdminId(String userId);

    Quiz updateQuizStatus(String adminId, String quizId);

    List<Quiz> getAllQuizByActiveAdminId(String adminId);

    List<Quiz> getAllQuizByInActiveAdminId(String adminId);
}
