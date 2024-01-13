package net.javaguides.springboot.backend.repository;

import net.javaguides.springboot.backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.category.categoryId = :categoryId AND NOT EXISTS (" +
            "SELECT b FROM Book b WHERE b.room.roomId = r.roomId AND (" +
            "   (b.checkInDate BETWEEN :checkInDate AND :checkOutDate) OR " +
            "   (b.checkOutDate BETWEEN :checkInDate AND :checkOutDate) OR " +
            "   (:checkInDate BETWEEN b.checkInDate AND b.checkOutDate) OR " +
            "   (:checkOutDate BETWEEN b.checkInDate AND b.checkOutDate)))")
    List<Room> findAvailableRooms(@Param("checkInDate") LocalDate checkInDate,
                                  @Param("checkOutDate") LocalDate checkOutDate,
                                  @Param("categoryId") int categoryId
    );
}
