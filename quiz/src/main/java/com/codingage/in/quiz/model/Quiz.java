package com.codingage.in.quiz.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quiz")
public class Quiz {
    @Id
    private String id;

    @NotNull
    @NotBlank
    private String adminId;

    @NotBlank
    private String description;

    @NotNull
    @Positive
    private long durationInMinutes;
    private boolean active = true;
}
