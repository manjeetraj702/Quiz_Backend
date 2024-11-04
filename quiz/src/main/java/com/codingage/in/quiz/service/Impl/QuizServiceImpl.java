package com.codingage.in.quiz.service.Impl;

import com.codingage.in.quiz.exception.QuizException;
import com.codingage.in.quiz.model.Quiz;
import com.codingage.in.quiz.model.request.CreateQuiz;
import com.codingage.in.quiz.model.request.UpdateQuiz;
import com.codingage.in.quiz.repository.QuizRepository;
import com.codingage.in.quiz.service.QuizService;
import com.codingage.in.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    UserService userService;
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Quiz createQuiz( CreateQuiz createQuiz) {
        userService.getAdminByAdminId(createQuiz.getAdminId());
        Quiz quiz = new Quiz();
        quiz.setDuration(createQuiz.getDuration());
        quiz.setDescription(createQuiz.getDescription());
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz( UpdateQuiz updateQuiz) {
      userService.getAdminByAdminId(updateQuiz.getAdminId());
        Optional<Quiz> existingQuizOptional = quizRepository.findById(updateQuiz.getId());
        if (existingQuizOptional.isPresent()) {
            Quiz existingQuiz = existingQuizOptional.get();
            existingQuiz.setDescription(updateQuiz.getDescription());
            existingQuiz.setDuration(updateQuiz.getDuration());

            return quizRepository.save(existingQuiz);
        }
            throw new QuizException("Quiz not found");


    }

    @Override
    public Quiz getQuizById(String userId, String quizId) {
        userService.getAdminByAdminId(userId);
        Optional<Quiz> existingQuizOptional = quizRepository.findById(quizId);
        if (existingQuizOptional.isPresent()) {

            return existingQuizOptional.get();
        }
        throw new QuizException("Quiz not found");

    }

    @Override
    public Quiz getQuizById(String quizId) {
        Optional<Quiz> existingQuizOptional = quizRepository.findById(quizId);
        if (existingQuizOptional.isPresent()) {

            return existingQuizOptional.get();
        }
        throw new QuizException("Quiz not found");
    }

    @Override
    public Boolean deleteQuiz(String userId, String quizId) {
        userService.getAdminByAdminId(userId);
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            return true;
        }
        throw new QuizException("Quiz not present");
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }
}
