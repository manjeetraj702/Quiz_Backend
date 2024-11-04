package com.codingage.in.quiz.repository;

import com.codingage.in.quiz.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {
    List<Question> findAllByQuizId();
}