package com.imse.hotel.nosql.servicesmongo;


import com.imse.hotel.nosql.modelmongodb.BookedRoomMongoDb;
import com.imse.hotel.nosql.modelmongodb.BookedRoomsMongoByCustomer;
import com.imse.hotel.nosql.repositorymongodb.BookedRoomsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedRoomsMongoService {

    @Autowired
    private BookedRoomsMongoRepository bookedRoomsMongoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    public List<BookedRoomsMongoByCustomer> findAllBookedRoomsByCustomer(String id){

        Query query = new Query();
        query.addCriteria(Criteria.where("customerRef.customerId").is(id));

        List<BookedRoomMongoDb> list = this.mongoTemplate.find(query, BookedRoomMongoDb.class);

        List<BookedRoomsMongoByCustomer> ret = new ArrayList<>();
        for(BookedRoomMongoDb temp : list){
            BookedRoomsMongoByCustomer bookedRoom = new BookedRoomsMongoByCustomer();

            bookedRoom.setRoomId(temp.getRoomId());
            bookedRoom.setCheckOutDate(temp.getCheckOutDate());
            bookedRoom.setCustomerID(temp.getCustomerRef().getCustomerId());

            ret.add(bookedRoom);
        }

        return ret;





    }











}
