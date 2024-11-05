package com.codingage.in.quiz.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Document(collection = "question")
public class Question {
    @Id
    private String id;

    @NotNull
    private String quizId;

    @NotBlank
    private String questionText;

    private final String[] options = new String[4];

    @Min(0)
    @Max(3)
    private int correctOption;
}
