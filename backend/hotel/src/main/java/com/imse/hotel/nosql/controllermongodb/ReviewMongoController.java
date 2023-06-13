package com.imse.hotel.nosql.controllermongodb;


import com.imse.hotel.nosql.modelmongodb.MostReviewedRoomsMongo;
import com.imse.hotel.nosql.modelmongodb.MostReviewsReport;
import com.imse.hotel.nosql.modelmongodb.RoomReviewingMongoDb;
import com.imse.hotel.nosql.modelmongodb.RoomReviewingMongoRequest;
import com.imse.hotel.nosql.servicesmongo.ReviewMongoService;
import com.imse.hotel.sql.model.MostReviewedRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ReviewMongoController {

    @Autowired
    private ReviewMongoService reviewMongoService;


    @RequestMapping(value = "/addReview", method = RequestMethod.PUT)
    @ResponseBody
    public RoomReviewingMongoDb getAddReview(@RequestBody RoomReviewingMongoRequest request){
        return reviewMongoService.assignReview(request);
    }


    @GetMapping("/mostReviews/{age}")
    public List<MostReviewsReport> getMostReviews(@PathVariable String age){
        return this.reviewMongoService.findMostReviews(age);
    }



}
