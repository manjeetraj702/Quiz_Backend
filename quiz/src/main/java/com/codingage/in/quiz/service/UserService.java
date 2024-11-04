package com.codingage.in.quiz.service;

import com.codingage.in.quiz.model.User;
import com.codingage.in.quiz.model.request.UserSignIn;
import com.codingage.in.quiz.model.request.UserSignUp;

import java.util.List;

public interface UserService {

    User userSignUp(UserSignUp userSignUp);

    User userSignIn(UserSignIn userSignIn);

    User getAdminByAdminId(String userId);
    User getStudentByUserId(String userId);

    List<User> getAllUsers();
}
