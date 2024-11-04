package com.codingage.in.quiz.service.Impl;

import com.codingage.in.quiz.exception.QuizException;
import com.codingage.in.quiz.model.Result;
import com.codingage.in.quiz.model.request.CreateResult;
import com.codingage.in.quiz.repository.ResultRepository;
import com.codingage.in.quiz.service.QuizService;
import com.codingage.in.quiz.service.ResultService;
import com.codingage.in.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository repository;
    @Autowired
    UserService userService;
    @Autowired
    QuizService quizService;

    @Override
    public Result createResult(CreateResult createResult) {
        userService.getStudentByUserId(createResult.getStudentId());
        Result result = new Result();
        result.setStudentId(createResult.getStudentId());
        result.setTotalQuestions(createResult.getTotalQuestions());
        result.setTotalCorrectQuestions(createResult.getTotalCorrectQuestions());
        return repository.save(result);
    }

    @Override
    public Result getResultByUserIdAndQuizId(String userId, String quizId, String resultId) {
        userService.getStudentByUserId(userId);
        quizService.getQuizById(quizId);
        Optional<Result> result = repository.findById(resultId);
        if (result.isPresent()) {
            return result.get();
        }
        throw new QuizException("Result not found");
    }

    @Override
    public List<Result> getResultsByUserId(String userId) {
        userService.getStudentByUserId(userId);
        return repository.findByStudentId();
    }

    @Override
    public List<Result> getResultsByQuizId(String quizId) {
        quizService.getQuizById(quizId);
        return repository.findByQuizId();
    }
}
