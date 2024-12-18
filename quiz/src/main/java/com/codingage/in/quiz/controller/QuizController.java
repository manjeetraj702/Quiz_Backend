package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.model.Quiz;
import com.codingage.in.quiz.model.request.CreateQuiz;
import com.codingage.in.quiz.model.request.UpdateQuiz;
import com.codingage.in.quiz.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ApiResponse<Quiz> createQuiz( @Valid  @RequestBody CreateQuiz createQuiz) {
        Quiz quiz = quizService.createQuiz(createQuiz);
        return new ApiResponse<>(quiz, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateQuiz")
    public ApiResponse<Quiz> updateQuiz(@RequestParam UpdateQuiz updateQuiz) {
        Quiz quiz = quizService.updateQuiz(updateQuiz);
        return new ApiResponse<>(quiz, HttpStatus.OK);
    }

    @GetMapping("/getQuizById")
    public ApiResponse<Quiz> getQuizById(@RequestParam String userId, String quizId) {
        Quiz quiz = quizService.getQuizById(userId, quizId);
        return new ApiResponse<>(quiz, HttpStatus.OK);
    }

    @DeleteMapping("/deleteQuiz")
    public ApiResponse<Boolean> deleteQuiz(@RequestParam String adminId, String quizId) {
        Boolean isDelete = quizService.deleteQuiz(adminId, quizId);
        return new ApiResponse<>(isDelete, HttpStatus.OK);
    }

    @GetMapping("/getAllQuiz")
    public ApiResponse<List<Quiz>> getAllQuiz() {
        List<Quiz> quizzes = quizService.getAllQuiz();
        return new ApiResponse<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/getAllActiveQuiz")
    public ApiResponse<List<Quiz>> getAllActiveQuiz() {
        List<Quiz> quizzes = quizService.getAllActiveQuiz();
        return new ApiResponse<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/getAllQuizByAdminId")
    public ApiResponse<List<Quiz>> getAllQuizByAdminId(@RequestParam String adminId) {
        List<Quiz> quizzes = quizService.getAllQuizByAdminId(adminId);
        return new ApiResponse<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/getAllQuizByActiveAdminId")
    public ApiResponse<List<Quiz>> getAllQuizByActiveAdminId(@RequestParam String adminId) {
        List<Quiz> quizzes = quizService.getAllQuizByActiveAdminId(adminId);
        return new ApiResponse<>(quizzes, HttpStatus.OK);
    }

    @PutMapping("/updateQuizStatus")
    public ApiResponse<Quiz> updateQuizStatus(@RequestParam String adminId, String quizId) {
        Quiz quiz = quizService.updateQuizStatus(adminId, quizId);
        return new ApiResponse<>(quiz, HttpStatus.OK);
    }
    @GetMapping("/getAllQuizByInActiveAdminId")
    public ApiResponse<List<Quiz>> getAllQuizByInActiveAdminId(@RequestParam String adminId) {
        List<Quiz> quizzes = quizService.getAllQuizByInActiveAdminId(adminId);
        return new ApiResponse<>(quizzes, HttpStatus.OK);
    }

}
