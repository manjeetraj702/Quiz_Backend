package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.model.User;
import com.codingage.in.quiz.model.request.UserSignIn;
import com.codingage.in.quiz.model.request.UserSignUp;
import com.codingage.in.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ApiResponse<User> signUp(@RequestBody UserSignUp userSignUp) {
        User createdUser = userService.userSignUp(userSignUp);
        return new ApiResponse<>(HttpStatus.CREATED, createdUser); // Changed to CREATED
    }

    @PostMapping("/signIn")
    public ApiResponse<User> signIn(@RequestBody UserSignIn userSignIn) {
        User user = userService.userSignIn(userSignIn);
        return new ApiResponse<>(HttpStatus.OK, user);
    }


}
