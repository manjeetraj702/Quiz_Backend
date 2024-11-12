package com.codingage.in.quiz.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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


    @Size(min = 4, max = 4, message = "There must be exactly 4 options")
    private List<@NotBlank String> options;  // Ensures exactly 4 non-blank options

    @Min(0)
    @Max(3)
    private int correctOption;  // Ensures it's within 0-3 range for 4 options
}
