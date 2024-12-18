package com.codingage.in.quiz.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateResult {

    @NotNull
    private String studentId;
    @NotNull
    private String questionTitle;
    @NotNull
    private String quizId;


    @Min(0)
    private int totalQuestions;

    @Min(0)
    private int totalCorrectQuestions;
}
