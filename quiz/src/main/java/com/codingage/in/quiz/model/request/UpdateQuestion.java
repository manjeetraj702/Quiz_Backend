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
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuestion {

    @NotNull
    @NotBlank
    private String adminId;

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String quizId;

    @NotNull
    @NotBlank
    private String questionText;

    @NotNull
    private final String[] options = new String[4];  // Initialized with a fixed length of 4

    @Min(0)
    @Max(3)
    private int correctOption;  // Ensures it's between 0 and 3 for valid indexing
}
