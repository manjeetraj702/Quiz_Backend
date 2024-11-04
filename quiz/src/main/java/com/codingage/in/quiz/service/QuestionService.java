package com.codingage.in.quiz.service;

import com.codingage.in.quiz.model.Question;
import com.codingage.in.quiz.model.request.QuestionRequest;
import com.codingage.in.quiz.model.request.UpdateQuestion;

import java.util.List;

public interface QuestionService {
    Question createQuestion(String userId, QuestionRequest questionRequest);

    Question updateQuestion(String userId, UpdateQuestion updateQuestion);

    List<Question> getQuestionsByQuizId(String quizId);

}