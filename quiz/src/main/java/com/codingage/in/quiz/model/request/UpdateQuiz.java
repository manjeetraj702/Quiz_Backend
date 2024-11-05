package com.codingage.in.quiz.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

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

    private String description;

    private Duration duration;
}
