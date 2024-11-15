package com.codingage.in.quiz.repository;

import com.codingage.in.quiz.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository<Quiz,String> {
    List<Quiz> findAllByAdminId(String adminId);
}
