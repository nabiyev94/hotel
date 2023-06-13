package com.imse.hotel.nosql.repositorymongodb;

import com.imse.hotel.nosql.modelmongodb.CategoryMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMongoDbRepository extends MongoRepository<CategoryMongoDb, String> {

    CategoryMongoDb findByCategoryId(String categoryId);
}
