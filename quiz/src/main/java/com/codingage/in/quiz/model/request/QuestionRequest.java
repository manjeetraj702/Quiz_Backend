package com.codingage.in.quiz.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private String adminId;
    private String quizId;
    private String questionText;
    final private String[] options = new String[4];
    private int correctOption;
}
