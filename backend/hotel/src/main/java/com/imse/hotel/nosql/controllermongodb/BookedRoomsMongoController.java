package com.imse.hotel.nosql.controllermongodb;


import com.imse.hotel.nosql.modelmongodb.BookedRoomsMongoByCustomer;
import com.imse.hotel.nosql.servicesmongo.BookedRoomsMongoService;
import com.imse.hotel.sql.model.BookedRoomByCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookedRoomsMongoController {

    @Autowired
    private BookedRoomsMongoService bookedRoomsMongoService;


    @GetMapping("/findRooms/{customerId}")
    public List<BookedRoomsMongoByCustomer> findAllRooms(@PathVariable String customerId){
        return this.bookedRoomsMongoService.findAllBookedRoomsByCustomer(customerId);
    }
}
