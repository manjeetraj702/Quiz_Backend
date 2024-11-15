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
        quiz.setAdminId(createQuiz.getAdminId());
        quiz.setDurationInMinutes(createQuiz.getDurationInMinutes());
        quiz.setDescription(createQuiz.getDescription());
        quiz.setTitle(createQuiz.getTitle());
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz( UpdateQuiz updateQuiz) {
      userService.getAdminByAdminId(updateQuiz.getAdminId());
        Optional<Quiz> existingQuizOptional = quizRepository.findById(updateQuiz.getId());
        if (existingQuizOptional.isPresent()) {
            Quiz existingQuiz = existingQuizOptional.get();
            existingQuiz.setDescription(updateQuiz.getDescription());
            existingQuiz.setDurationInMinutes(updateQuiz.getDurationInMinutes());
            existingQuiz.setTitle(updateQuiz.getTitle());

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
            quizRepository.delete(quiz.get());
            return true;
        }
        throw new QuizException("Quiz not present");
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public List<Quiz> getAllActiveQuiz() {
        List<Quiz> quizzes=quizRepository.findAll();
        for(int i=0;i<quizzes.size();i++)
        {
            if(!quizzes.get(i).isActive())
            {
                quizzes.remove(quizzes.get(i));
            }
        }
        return quizzes;
    }

    @Override
    public List<Quiz> getAllQuizByAdminId(String adminId) {
        return quizRepository.findAllByAdminId(adminId);
    }

    @Override
    public Quiz updateQuizStatus(String adminId, String quizId) {
        userService.getAdminByAdminId(adminId);
        Optional<Quiz> existingQuizOptional = quizRepository.findById(quizId);
        if (existingQuizOptional.isPresent()) {
            Quiz existingQuiz = existingQuizOptional.get();
            existingQuiz.setActive(!existingQuiz.isActive());

            return quizRepository.save(existingQuiz);
        }
        throw new QuizException("Quiz not found");

    }

    @Override
    public List<Quiz> getAllQuizByActiveAdminId(String adminId) {
        List<Quiz> quizzes = quizRepository.findAllByAdminId(adminId);

        for(int i=0;i<quizzes.size();i++)
        {
            if(!quizzes.get(i).isActive())
            {
                quizzes.remove(quizzes.get(i));
            }
        }
        return quizzes;

    }

    @Override
    public List<Quiz> getAllQuizByInActiveAdminId(String adminId) {
        List<Quiz> quizzes = quizRepository.findAllByAdminId(adminId);

        for(int i=0;i<quizzes.size();i++)
        {
            if(quizzes.get(i).isActive())
            {
                quizzes.remove(quizzes.get(i));
            }
        }
        return quizzes;
    }
}
