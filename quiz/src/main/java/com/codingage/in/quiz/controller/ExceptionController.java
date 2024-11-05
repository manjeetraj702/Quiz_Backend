package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.exception.QuizException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> generaException(Exception e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setErrorMessage(e.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(QuizException.class)
    public ApiResponse<Object> applicationExceptionHandler(QuizException e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK);
        response.setErrorMessage(e.getMessage());
        return response;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> badRequestExceptionHandler(Exception e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.BAD_REQUEST);
        response.setErrorMessage(e.getMessage());
        return response;
    }
}

