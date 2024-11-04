package com.codingage.in.quiz.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuiz {
    private String adminId;
    private String id;
    private String description;
    private Time duration;
}
