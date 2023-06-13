package com.imse.hotel.sql.controller;

import com.imse.hotel.sql.model.MostReviewedRoom;
import com.imse.hotel.sql.model.RoomReviewing;
import com.imse.hotel.sql.model.RoomReviewingRequest;
import com.imse.hotel.sql.service.RoomReviewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RoomReviewingController {

    @Autowired
    private RoomReviewingService roomReviewingService;




    /*
    @PutMapping("room/{roomId}/customer/{customerId}")
    public RoomReviewing reviewRoom(@PathVariable Long roomId, @PathVariable Long customerId){
        return roomReviewingService.assignReviewToRoom(roomId, customerId);
    }

    @PutMapping("/updatingCustomerReview")
    public RoomReviewing updatingCustomerReview(@RequestBody RoomReviewing roomReviewing){
        return this.roomReviewingService.updateReview(roomReviewing);
    }*/



    @RequestMapping(value = "/reviewRoom", method = RequestMethod.PUT)
    @ResponseBody
    public RoomReviewing getReviewRoom(@RequestBody RoomReviewingRequest roomReviewingRequest){
        return roomReviewingService.assignReviewToRoom(roomReviewingRequest);
    }



    @GetMapping("/most/{age}")
    public List<MostReviewedRoom> getMostReviewedRooms(@PathVariable String age){
        return this.roomReviewingService.findMostRooms(age);
    }















}
