package com.codingage.in.quiz.service;

import com.codingage.in.quiz.model.User;
import com.codingage.in.quiz.model.request.UserSignIn;
import com.codingage.in.quiz.model.request.UserSignUp;
import com.codingage.in.quiz.model.response.SignInResponse;

import java.util.List;

public interface UserService {

    User userSignUp(UserSignUp userSignUp);

    SignInResponse userSignIn(UserSignIn userSignIn);

    User getAdminByAdminId(String userId);

    User getStudentByUserId(String userId);

    List<User> getAllUsers();
}
