package com.codingage.in.quiz.service.Impl;

import com.codingage.in.quiz.model.Result;
import com.codingage.in.quiz.model.request.CreateResult;
import com.codingage.in.quiz.repository.ResultRepository;
import com.codingage.in.quiz.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository repository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    QuizServiceImpl quizService;

    @Override
    public Result createResult(CreateResult createResult) {
        return null;
    }

    @Override
    public Result getResultByUserIdAndQuizId(String userId, String quizId) {
        return null;
    }

    @Override
    public List<Result> getResultsByUserId(String userId) {
        return List.of();
    }

    @Override
    public List<Result> getResultsByQuizId(String quizId) {
        return List.of();
    }
}
