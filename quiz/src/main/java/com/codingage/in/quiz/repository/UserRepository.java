package com.codingage.in.quiz.repository;

import com.codingage.in.quiz.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByPhoneNumber(String userName);
}
