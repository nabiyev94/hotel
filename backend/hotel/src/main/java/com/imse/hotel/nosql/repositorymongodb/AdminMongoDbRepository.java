package com.imse.hotel.nosql.repositorymongodb;

import com.imse.hotel.nosql.modelmongodb.AdminMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminMongoDbRepository extends MongoRepository<AdminMongoDb, String> {
}
