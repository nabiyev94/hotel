package net.javaguides.springboot.backend.repository.mongoRepository;

import net.javaguides.springboot.backend.model.mongo.CustomerMongo;
import net.javaguides.springboot.backend.model.mongo.ReviewMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerMongoRepository extends MongoRepository<CustomerMongo, String> {

  CustomerMongo findByCustomerMongoId(String customerMongoId);

}
