package com.codingage.in.quiz.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuiz {

    @NotNull
    @NotBlank
    private String adminId;


    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @Positive
    private long durationInMinutes;
}
