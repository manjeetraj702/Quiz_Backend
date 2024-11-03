package com.codingage.in.quiz.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuestion {
    private String id;
    private String quizId;
    private String questionText;
    final private String[] options = new String[4];
    private int correctOption;
}
