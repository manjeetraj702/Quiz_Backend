package com.codingage.in.quiz.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    @NotNull
    @NotBlank
    private String adminId;

    @NotNull
    @NotBlank
    private String quizId;

    @NotNull
    @NotBlank
    private String questionText;

    @NotNull
    private final String[] options = new String[4];  // Ensures array is initialized with a fixed length

    @Min(0)
    @Max(3)
    private int correctOption;  // Ensures it's within 0-3 range for 4 options
}
