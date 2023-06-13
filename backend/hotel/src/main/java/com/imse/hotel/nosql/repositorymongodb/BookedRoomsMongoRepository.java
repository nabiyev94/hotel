package com.imse.hotel.nosql.repositorymongodb;

import com.imse.hotel.nosql.modelmongodb.BookedRoomMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface BookedRoomsMongoRepository extends MongoRepository<BookedRoomMongoDb, String> {
}
