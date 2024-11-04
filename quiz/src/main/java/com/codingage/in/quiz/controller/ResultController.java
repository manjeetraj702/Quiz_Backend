package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.model.Result;
import com.codingage.in.quiz.model.request.CreateResult;
import com.codingage.in.quiz.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/result")
public class ResultController {
    @Autowired
    ResultService service;

    @PostMapping("/createResult")
    public ApiResponse<Result> createResult(CreateResult createResult) {
        Result result = service.createResult(createResult);
        return new ApiResponse<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getResultByUserIdAndQuizId")
    public ApiResponse<Result> getResultByUserIdAndQuizId(String userId, String quizId, String resultId) {
        Result result = service.getResultByUserIdAndQuizId(userId, quizId, resultId);
        return new ApiResponse<>(result, HttpStatus.OK);
    }

    @GetMapping("/getResultsByUserId")
    public ApiResponse<List<Result>> getResultsByUserId(String userId) {
        List<Result> results = service.getResultsByUserId(userId);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    @GetMapping("/getResultsByQuizId")
    public ApiResponse<List<Result>> getResultsByQuizId(String quizId) {
        List<Result> results = service.getResultsByUserId(quizId);
        return new ApiResponse<>(results, HttpStatus.OK);
    }
}
