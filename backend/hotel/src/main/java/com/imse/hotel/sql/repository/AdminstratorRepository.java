package com.imse.hotel.sql.repository;

import com.imse.hotel.sql.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminstratorRepository extends JpaRepository<Administrator, Long> {
}
