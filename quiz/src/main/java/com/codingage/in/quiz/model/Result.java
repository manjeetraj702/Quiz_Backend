package com.codingage.in.quiz.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "result")
public class Result {
    @Id
    private String id;

    @NotNull
    private String studentId;

    @NotNull
    private String quizId;

    @Min(0)
    private int totalQuestions;

    @Min(0)
    private int totalCorrectQuestions;


}
