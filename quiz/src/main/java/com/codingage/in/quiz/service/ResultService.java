package com.codingage.in.quiz.service;

import com.codingage.in.quiz.model.Result;
import com.codingage.in.quiz.model.request.CreateResult;

import java.util.List;

public interface ResultService {
    Result createResult(CreateResult createResult);
    Result getResultByUserIdAndQuizId(String userId,String quizId);
    List<Result> getResultsByUserId(String userId);
    List<Result> getResultsByQuizId(String quizId);
}
