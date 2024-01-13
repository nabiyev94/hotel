package net.javaguides.springboot.backend.repository.mongoRepository;

import net.javaguides.springboot.backend.model.mongo.CategoryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryMongoRepository extends MongoRepository<CategoryMongo, String> {
}
