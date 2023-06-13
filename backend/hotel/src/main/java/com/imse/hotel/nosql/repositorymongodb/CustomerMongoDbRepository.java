package com.imse.hotel.nosql.repositorymongodb;

import com.imse.hotel.nosql.modelmongodb.CustomerMongoDb;
import com.imse.hotel.sql.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMongoDbRepository extends MongoRepository<CustomerMongoDb, String> {

    @Query("{'cutomerEmailAdress': ?0}")
    CustomerMongoDb findByCutomerEmailAdress(String cutomerEmailAdress);
    CustomerMongoDb findByCustomerId(String customerId);
}
