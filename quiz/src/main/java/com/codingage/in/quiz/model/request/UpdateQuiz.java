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
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuiz {

    @NotNull
    @NotBlank
    private String adminId;

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @Positive
    private long durationInMinutes;
}
