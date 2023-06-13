package com.imse.hotel.sql.controller;

import com.imse.hotel.sql.model.BookedRoom;
import com.imse.hotel.sql.model.BookedRoomByCustomer;
import com.imse.hotel.sql.model.BookedRoomRequest;
import com.imse.hotel.sql.service.BookedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(path = "/bookedRoom")
public class BookedRoomController {

    @Autowired
    private BookedRoomService bookedRoomService;



    @RequestMapping(value = "/Test", method = RequestMethod.PUT)
    @ResponseBody
    public BookedRoom getTest(@RequestBody BookedRoomRequest bookedRoomRequest){
        return bookedRoomService.assignRoom(bookedRoomRequest);
    }


    @GetMapping("/findby/{customerId}")
    public List<BookedRoomByCustomer> findAllRooms(@PathVariable String customerId){

        return this.bookedRoomService.findByCustomerIdAllRooms(customerId);
    }




}
