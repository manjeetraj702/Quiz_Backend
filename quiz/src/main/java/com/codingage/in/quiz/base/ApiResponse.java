package com.codingage.in.quiz.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter

public class ApiResponse <T>{
    private T data;
    private HttpStatus httpStatus;
    private String errorMessage;

    public ApiResponse(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public ApiResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ApiResponse(HttpStatus httpStatus, T data) {
       this.httpStatus=httpStatus;
        this.data = data;
    }
}
