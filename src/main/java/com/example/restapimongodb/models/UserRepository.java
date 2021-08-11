package com.example.restapimongodb.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {


    // this tells mongo that there needs to be an implementation for this
    UserModel findByUsername(String username);
}
