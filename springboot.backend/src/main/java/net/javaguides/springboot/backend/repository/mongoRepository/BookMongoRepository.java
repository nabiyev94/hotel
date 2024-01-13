package net.javaguides.springboot.backend.repository.mongoRepository;

import net.javaguides.springboot.backend.model.mongo.BookMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookMongoRepository extends MongoRepository<BookMongo, String> {
    @Query("{ 'customerMongoId': ?0 }")
    List<BookMongo> findRoomsByCustomerId(String customerMongoId);
}
