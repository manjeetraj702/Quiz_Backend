package com.codingage.in.quiz.controller;

import com.codingage.in.quiz.base.ApiResponse;
import com.codingage.in.quiz.model.Question;
import com.codingage.in.quiz.model.request.QuestionRequest;
import com.codingage.in.quiz.model.request.UpdateQuestion;
import com.codingage.in.quiz.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/createQuestion")
    public ApiResponse<Question> createQuestion(@Valid @RequestBody QuestionRequest questionRequest) {
        Question question = questionService.createQuestion(questionRequest);
        return new ApiResponse<>(question, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateQuestion")
    public ApiResponse<Question> updateQuestion(@Valid @RequestBody UpdateQuestion updateQuestion) {
        Question question = questionService.updateQuestion(updateQuestion);
        return new ApiResponse<>(question, HttpStatus.OK);
    }

    @GetMapping("/getQuestionsByQuizId")
    public ApiResponse<List<Question>> getQuestionsByQuizId(@Valid @RequestParam  String quizId) {
        List<Question> questions = questionService.getQuestionsByQuizId(quizId);
        return new ApiResponse<>(questions, HttpStatus.OK);
    }
}
