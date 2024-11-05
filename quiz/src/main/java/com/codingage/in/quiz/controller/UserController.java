package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.model.User;
import com.codingage.in.quiz.model.request.UserSignIn;
import com.codingage.in.quiz.model.request.UserSignUp;
import com.codingage.in.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai/v1/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ApiResponse<User> signUp(@RequestBody UserSignUp userSignUp) {
        User createdUser = userService.userSignUp(userSignUp);
        return new ApiResponse<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ApiResponse<User> signIn(@RequestBody UserSignIn userSignIn) {
        User user = userService.userSignIn(userSignIn);
        return new ApiResponse<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAdminByUserId")
    public ApiResponse<User> getAdminByUserId(@RequestParam String userId) {
        User user = userService.getAdminByAdminId(userId);
        return new ApiResponse<>(user, HttpStatus.OK);
    }

    @GetMapping("/getStudentByUserId")
    public ApiResponse<User> getStudentByUserId(String userId) {
        User user = userService.getAdminByAdminId(userId);
        return new ApiResponse<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ApiResponse<>(users, HttpStatus.OK);
    }


}
