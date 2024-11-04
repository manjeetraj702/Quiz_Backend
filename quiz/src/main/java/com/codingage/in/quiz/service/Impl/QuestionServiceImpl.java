package com.codingage.in.quiz.service.Impl;

import com.codingage.in.quiz.exception.QuizException;
import com.codingage.in.quiz.model.Question;
import com.codingage.in.quiz.model.request.QuestionRequest;
import com.codingage.in.quiz.model.request.UpdateQuestion;
import com.codingage.in.quiz.repository.QuestionRepository;
import com.codingage.in.quiz.service.QuestionService;
import com.codingage.in.quiz.service.QuizService;
import com.codingage.in.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuizService quizService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question createQuestion(QuestionRequest questionRequest) {
        userService.getAdminByAdminId(questionRequest.getAdminId());
        Question question = new Question();
        question.setQuestionText(questionRequest.getQuestionText());
        question.setQuizId(questionRequest.getQuizId());
        question.setCorrectOption(questionRequest.getCorrectOption());
        for (int i = 0; i < 4; i++) {
            question.getOptions()[i] = questionRequest.getOptions()[i];
        }

        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion( UpdateQuestion updateQuestion) {
        userService.getAdminByAdminId(updateQuestion.getAdminId());
        Optional<Question> question = questionRepository.findById(updateQuestion.getId());
        if (question.isPresent()) {
            Question question1 = question.get();
            question1.setQuestionText(updateQuestion.getQuestionText());
            question1.setCorrectOption(updateQuestion.getCorrectOption());

        }
        throw new QuizException("Question is not present");
    }

    @Override
    public List<Question> getQuestionsByQuizId(String quizId) {
        quizService.getQuizById(quizId);
        return questionRepository.findAllByQuizId();
    }
}
