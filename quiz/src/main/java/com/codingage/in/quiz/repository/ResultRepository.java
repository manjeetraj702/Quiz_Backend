package com.codingage.in.quiz.repository;

import com.codingage.in.quiz.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends MongoRepository<Result,String> {
}
