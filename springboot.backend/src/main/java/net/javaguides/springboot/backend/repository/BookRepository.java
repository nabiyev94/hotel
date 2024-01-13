package net.javaguides.springboot.backend.repository;

import net.javaguides.springboot.backend.model.Book;
import net.javaguides.springboot.backend.model.Review;
import net.javaguides.springboot.backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface  BookRepository extends JpaRepository<Book, Long> {
/*
    @Query(value = "SELECT customer.email, room.roomId, booked.checkOutDate" +
            " from Room room join Book booked on room.roomId = booked.room.roomId " +
            "join Customer customer on booked.customer.email = customer.email" +
            " where customer.email = :email")
    List<Object[]> findAllRooms(@Param("email") String email);  */


    @Query( "SELECT DISTINCT customer.email, room.roomId, booked.checkOutDate " +
    "FROM Room room " +
    "JOIN Book booked ON room.roomId = booked.room.roomId " +
    "JOIN Customer customer ON booked.customer.email = customer.email "  +
    "WHERE customer.email = :email")
    List<Object[]> findAllRooms(@Param("email") String email);

    @Query(value = "select room.room_id, cat.category_id, COUNT(room.room_id) AS count_of_bookings" +
            " from room room join book b ON room.room_id = b.room_id " +
            "join customer customer ON customer.customer_id = r.customer_id " +
            "JOIN Category cat ON room.category_id = cat.category_id " +
            "WHERE customer.first_name = :first_name " +
            "GROUP BY room.room_id, cat.category_id " +
            "order by count_of_reviews DESC", nativeQuery = true)
    List<Object[]> findReviewsByCustomerFirstName(@Param("first_name") String first_name);
}
