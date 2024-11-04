package com.codingage.in.quiz.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuiz {
    private String adminId;
    private String description;
    private Time duration;
}
