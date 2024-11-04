package com.codingage.in.quiz.repository;

import com.codingage.in.quiz.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends MongoRepository<Result,String> {
    List<Result> findByStudentId();

    List<Result> findByQuizId();
}
