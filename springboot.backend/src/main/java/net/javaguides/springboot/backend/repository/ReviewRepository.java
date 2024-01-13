package net.javaguides.springboot.backend.repository;

import net.javaguides.springboot.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select room.room_id, cat.category_id, COUNT(room.room_id) AS count_of_reviews" +
            " from room room join review r ON room.room_id = r.room_id " +
            "join customer customer ON customer.customer_id = r.customer_id " +
            "JOIN Category cat ON room.category_id = cat.category_id " +
            "WHERE customer.first_name = :first_name " +
            "GROUP BY room.room_id, cat.category_id " +
            "order by count_of_reviews DESC", nativeQuery = true)
    List<Object[]> findReviewsByCustomerFirstName(@Param("first_name") String first_name);

}





