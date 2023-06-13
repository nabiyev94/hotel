package com.imse.hotel.sql.repository;

import com.imse.hotel.sql.model.BookingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCartRepository extends JpaRepository<BookingCart, Long> {
}
