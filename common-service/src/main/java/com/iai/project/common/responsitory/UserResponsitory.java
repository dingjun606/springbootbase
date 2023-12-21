package com.iai.project.common.responsitory;

import com.iai.project.common.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserResponsitory extends MongoRepository<User,String> {
}
