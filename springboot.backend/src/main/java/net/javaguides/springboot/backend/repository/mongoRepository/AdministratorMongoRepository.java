package net.javaguides.springboot.backend.repository.mongoRepository;

import net.javaguides.springboot.backend.model.mongo.AdministratorMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministratorMongoRepository extends MongoRepository<AdministratorMongo, String> {
}
