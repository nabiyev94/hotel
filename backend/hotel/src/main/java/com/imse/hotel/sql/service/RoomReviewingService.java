package com.imse.hotel.sql.service;

import com.imse.hotel.sql.model.*;
import com.imse.hotel.sql.repository.CustomerRepository;
import com.imse.hotel.sql.repository.RoomRepository;
import com.imse.hotel.sql.repository.RoomReviewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomReviewingService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomReviewingRepository roomReviewingRepository;



    /*
    public RoomReviewing assignReviewToRoom(Long roomId, Long customerId){

        Customer customer = this.customerRepository.findById(customerId).get();
        Room room = this.roomRepository.findById(roomId).get();

        RoomReviewing roomReviewing = new RoomReviewing();
        roomReviewing.setCustomer(customer);
        roomReviewing.setRoom(room);

        return this.roomReviewingRepository.save(roomReviewing);
    }


    public RoomReviewing updateReview(RoomReviewing roomReviewing){
        RoomReviewing temp = this.roomReviewingRepository.findById(roomReviewing.getRoomReviewingID()).orElse(null);

        temp.setReviewText(roomReviewing.getReviewText());
        return this.roomReviewingRepository.save(temp);
    }*/



    public RoomReviewing assignReviewToRoom(RoomReviewingRequest roomReviewingRequest){

        Customer customer = this.customerRepository.findById(Integer.parseInt(roomReviewingRequest.getCustomer_id())).get();
        Room room = this.roomRepository.findById(Integer.parseInt(roomReviewingRequest.getRoom_id())).get();

        RoomReviewing roomReviewing = new RoomReviewing();
        roomReviewing.setCustomer(customer);
        roomReviewing.setRoom(room);
        roomReviewing.setReviewText(roomReviewingRequest.getReviewText());
        roomReviewing.setReviewDate(roomReviewingRequest.getReviewDate());

        room.getReviewedRooms().add(roomReviewing);
        customer.getReviewedRooms().add(roomReviewing);

        this.roomRepository.save(room);
        this.customerRepository.save(customer);

        return this.roomReviewingRepository.save(roomReviewing);
    }




    public List<MostReviewedRoom> findMostRooms(String age){
        List<Object[]> temp = roomReviewingRepository.findMostReviewedRooms(age);

        List<MostReviewedRoom> mostReviewedRooms = new ArrayList<>();

        for(Object[] tempObject : temp){
            MostReviewedRoom most = new MostReviewedRoom(tempObject[0].toString(), tempObject[1].toString(), tempObject[2].toString());
            mostReviewedRooms.add(most);
        }


        return mostReviewedRooms;
    }


























}
