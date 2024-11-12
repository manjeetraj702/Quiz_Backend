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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuizService quizService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(QuestionRequest questionRequest) {
        userService.getAdminByAdminId(questionRequest.getAdminId());

        Question question = new Question();
        question.setQuestionText(questionRequest.getQuestionText());
        question.setQuizId(questionRequest.getQuizId());
        question.setCorrectOption(questionRequest.getCorrectOption());
        question.setOptions(questionRequest.getOptions());  // Directly setting the options list

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
            questionRepository.save(question1);

        }
        throw new QuizException("Question is not present");
    }

    @Override
    public List<Question> getQuestionsByQuizId(String quizId) {
        quizService.getQuizById(quizId);
        return questionRepository.findAllByQuizId(quizId);
    }

    @Override
    public Boolean deleteQuestion(String questionId, String adminId) {
        userService.getAdminByAdminId(adminId);
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            Question question1 = question.get();
             questionRepository.delete(question1);
             return true;
        }
        throw new QuizException("Question is not present");

    }
}
