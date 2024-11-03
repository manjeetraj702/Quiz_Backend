package com.codingage.in.quiz.service.Impl;

import com.codingage.in.quiz.exception.QuizException;
import com.codingage.in.quiz.model.User;
import com.codingage.in.quiz.model.request.UserSignIn;
import com.codingage.in.quiz.model.request.UserSignUp;
import com.codingage.in.quiz.repository.UserRepository;
import com.codingage.in.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User userSignUp(UserSignUp userSignUp) {
        User user = userRepository.findByUserName(userSignUp.getUserName());
        if (user == null) {
            user = new User();
            user.setUserName(userSignUp.getUserName());
            user.setPassword(userSignUp.getPassword());
            user.setRole(userSignUp.getRole());
            return userRepository.save(user);
        }
        throw new QuizException("Username already present");
    }

    @Override
    public User userSignIn(UserSignIn userSignIn) {
        User user = userRepository.findByUserName(userSignIn.getUserName());
        if (user != null && user.getPassword().equals(userSignIn.getPassword())) {
            return user;
        }
        throw new QuizException("Credential mismatch");
    }

    @Override
    public User getAdminByUserId(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
        {
            if(user.get().getRole().equals("ADMIN"))
            {
            return user.get();
            }
            throw new QuizException("Only Admin can access ");
        }
        throw new QuizException("User not present");
    }

    @Override
    public User getStudentByUserId(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
        {
            if(user.get().getRole().equals("STUDENT"))
            {
                return user.get();
            }
            throw new QuizException("Only Student can access ");
        }
        throw new QuizException("User not present");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
