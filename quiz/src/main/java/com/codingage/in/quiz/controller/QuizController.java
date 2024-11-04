package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.model.Quiz;
import com.codingage.in.quiz.model.request.CreateQuiz;
import com.codingage.in.quiz.model.request.UpdateQuiz;
import com.codingage.in.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/createQuiz")
    public ApiResponse<Quiz> createQuiz(String userId, CreateQuiz createQuiz)
    {
        Quiz quiz=quizService.createQuiz(userId,createQuiz);
        return new ApiResponse<>(quiz,HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateQuiz")
    public ApiResponse<Quiz>  updateQuiz(String userId, UpdateQuiz updateQuiz)
    {
        Quiz quiz=quizService.updateQuiz(userId,updateQuiz);
        return new ApiResponse<>(quiz,HttpStatus.OK);
    }
    @GetMapping("/getQuizById")
    public ApiResponse<Quiz>  getQuizById(String userId, String quizId)
    {
        Quiz quiz=quizService.getQuizById(userId,quizId);
        return new ApiResponse<>(quiz,HttpStatus.OK);
    }

    
    public ApiResponse<Boolean>  deleteQuiz(String userId, String quizId)
    {
        Boolean isDelete=quizService.deleteQuiz(userId,quizId);
        return new ApiResponse<>(isDelete,HttpStatus.OK);
    }

    public ApiResponse<List<Quiz>>  getAllQuiz()
    {
        List<Quiz> quizzes=quizService.getAllQuiz();
        return new ApiResponse<>(quizzes,HttpStatus.OK);
    }

}
