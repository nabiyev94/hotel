package com.imse.hotel.sql.repository;

import com.imse.hotel.sql.model.RoomReviewing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomReviewingRepository extends JpaRepository<RoomReviewing, Long>{


    @Query(value = "select room.room_id, cat.category_id, COUNT(room.room_id) AS count_of_reviews" +
            " from room room join room_reviewing r ON room.room_id = r.room_id " +
            "join customer customer ON customer.customerID = r.customerid " +
            "JOIN Category cat ON room.category_id = cat.category_id " +
            "WHERE customer.age >= :age " +
            "GROUP BY room.room_id, cat.category_id " +
            "order by count_of_reviews", nativeQuery = true)
    List<Object[]> findMostReviewedRooms(@Param("age") String age);

}
