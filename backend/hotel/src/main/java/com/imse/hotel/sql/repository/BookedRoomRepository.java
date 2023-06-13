package com.imse.hotel.sql.repository;

import com.imse.hotel.sql.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, Integer> {

    /*
    @Query(value = "SELECT ro from room ro join bookedRoom r on ro.roomId = r.room.roomId " +
            "join customer c on r.customer.customerID = c.customerID")
    List<Room> findAllRooms(@Param("customerID") Long customerID);*/



    @Query(value = "SELECT customer.customerID, room.roomId, booked.checkOutDate" +
            " from room room join bookedRoom booked on room.roomId = booked.room.roomId " +
            "join customer customer on booked.customer.customerID = customer.customerID" +
            " where customer.customerID = :customerID")
    List<Object[]> findAllRooms(@Param("customerID") int customerID);





}

