package com.imse.hotel.nosql.servicesmongo;


import com.imse.hotel.nosql.modelmongodb.*;
import com.imse.hotel.nosql.repositorymongodb.CustomerMongoDbRepository;
import com.imse.hotel.nosql.repositorymongodb.ReviewingMongoRepository;
import com.imse.hotel.nosql.repositorymongodb.RoomMongoDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewMongoService {

    @Autowired
    private ReviewingMongoRepository reviewingMongoRepository;


    @Autowired
    private CustomerMongoDbRepository customerMongoDbRepository;

    @Autowired
    private RoomMongoDbRepository roomMongoDbRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    public RoomReviewingMongoDb assignReview(RoomReviewingMongoRequest request){


        CustomerMongoDb customer = this.customerMongoDbRepository.findByCustomerId(request.getCustomerId());
        RoomMongoDb room = this.roomMongoDbRepository.findByRoomId(request.getRoomId());
        RoomReviewingMongoDb review = new RoomReviewingMongoDb();

        CustomerRef customerRef = new CustomerRef();

        customerRef.setCustomerId(customer.getCustomerId());
        customerRef.setAge(customer.getAge());

        LocalDate reviewDate = LocalDate.now();
        review.setReviewText(request.getReviewText());
        review.setCustomerRef(customerRef);
        review.setRoomId(room.getRoomId());
        review.setReviewDate(reviewDate);

        return this.reviewingMongoRepository.save(review);

    }


    public List<MostReviewsReport> findMostReviews(String temp) {

        int age = Integer.parseInt(temp);
        MatchOperation matchOperation = Aggregation.match(new Criteria("customerRef.age").gte(age));
        GroupOperation groupByRoomId = Aggregation.group("roomId").count().as("count");
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.ASC, "count");
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, groupByRoomId, sortOperation);
        AggregationResults<MostReviewedRoomsMongo> output = this.mongoTemplate.aggregate(aggregation, "roomReviewingMongoDb", MostReviewedRoomsMongo.class);


        List<MostReviewedRoomsMongo> list = output.getMappedResults();
        List<MostReviewsReport> ret = new ArrayList<>();

        for (int i = 0; i < list.size(); ++i) {
            MostReviewsReport report = new MostReviewsReport();
            report.setRoom_id(list.get(i).getId());
            report.setCounter_of_Reviews(list.get(i).getCount());

            RoomMongoDb room = this.roomMongoDbRepository.findByRoomId(list.get(i).getId());
            report.setCategory_id(room.getCategoryId());

            ret.add(report);
        }

        return ret;
    }

}
