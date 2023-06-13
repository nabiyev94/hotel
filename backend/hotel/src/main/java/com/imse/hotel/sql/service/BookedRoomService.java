package com.imse.hotel.sql.service;

import com.imse.hotel.sql.model.*;
import com.imse.hotel.sql.repository.BookedRoomRepository;
import com.imse.hotel.sql.repository.CustomerRepository;
import com.imse.hotel.sql.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedRoomService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;




/*
    public BookedRoom assignRoom(Long roomId, Long customerId){
        Customer customer = this.customerRepository.findById(customerId).get();
        Room room = this.roomRepository.findById(roomId).get();

        //customer.getBookingCart().getRoomIDs().add(this.roomRepository.findById(room.getRoomId()).get().getRoomId());

        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setCheckInDate(new Date(2010-10-10));
        bookedRoom.setCheckOutDate(new Date(2015-10-10));
        bookedRoom.setRoom(room);
        customer.getBookedRooms().add(bookedRoom);
        bookedRoom.setCustomer(customer);
        room.getBookedRooms().add(bookedRoom);
        room.setAvailable(false);

        this.customerRepository.save(customer);
        this.roomRepository.save(room);

        return this.bookedRoomRepository.save(bookedRoom);
    }
*/


    public BookedRoom assignRoom(BookedRoomRequest bookedRoomRequest){
        Customer customer = this.customerRepository.findById(Integer.parseInt(bookedRoomRequest.getCustomer_id())).get();
        Room room = this.roomRepository.findById(Integer.parseInt(bookedRoomRequest.getRoom_id())).get();

        //customer.getBookingCart().getRoomIDs().add(this.roomRepository.findById(room.getRoomId()).get().getRoomId());

        BookedRoom bookedRoom = new BookedRoom();

        bookedRoom.setCheckInDate(bookedRoomRequest.getCheckInDate());
        bookedRoom.setCheckOutDate(bookedRoomRequest.getCheckOutDate());
        bookedRoom.setRoom(room);
        bookedRoom.setCustomer(customer);

        customer.getBookedRooms().add(bookedRoom);
        room.getBookedRooms().add(bookedRoom);
        room.setAvailable(false);

        this.customerRepository.save(customer);
        this.roomRepository.save(room);

        return this.bookedRoomRepository.save(bookedRoom);
    }


/*
    public List<Room> findByCustomerIdAllRooms(Long customerId){
        return this.bookedRoomRepository.findAllRooms(customerId);
    }*/



    public List<BookedRoomByCustomer> findByCustomerIdAllRooms(String str){

        int customerId = Integer.parseInt(str);

        List<Object[]> temp = bookedRoomRepository.findAllRooms(customerId);

        List<BookedRoomByCustomer> bookedRoomByCustomers = new ArrayList<>();

        for(Object[] tempObject : temp){
            BookedRoomByCustomer bookedRoom = new BookedRoomByCustomer(tempObject[0].toString(), tempObject[1].toString(), tempObject[2].toString());
            bookedRoomByCustomers.add(bookedRoom);
        }

        return bookedRoomByCustomers;
    }










}
