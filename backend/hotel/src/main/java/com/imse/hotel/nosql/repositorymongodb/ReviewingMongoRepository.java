package com.imse.hotel.nosql.repositorymongodb;

import com.imse.hotel.nosql.modelmongodb.RoomMongoDb;
import com.imse.hotel.nosql.modelmongodb.RoomReviewingMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewingMongoRepository extends MongoRepository<RoomReviewingMongoDb, String> {

    RoomReviewingMongoDb findByRoomId(String roomId);
}
