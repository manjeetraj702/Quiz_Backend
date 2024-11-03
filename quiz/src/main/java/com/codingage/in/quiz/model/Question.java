package com.codingage.in.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "question")
public class Question {
    @Id
    private String id;
    private String quizId;
    private String questionText;
    final private String[] options = new String[4];
    private int correctOption;
}
