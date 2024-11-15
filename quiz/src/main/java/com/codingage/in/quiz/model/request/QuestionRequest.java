package com.codingage.in.quiz.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    @NotBlank
    private String adminId;

    @NotBlank
    private String quizId;

    @NotNull
    @NotBlank
    private String questionText;

    @Size(min = 4, max = 4, message = "There must be exactly 4 options")
    private List<@NotBlank String> options;  // Ensures four non-blank options

    @Min(0)
    @Max(3)
    private int correctOption;  // Ensures it's within 0-3 range for 4 options
}
