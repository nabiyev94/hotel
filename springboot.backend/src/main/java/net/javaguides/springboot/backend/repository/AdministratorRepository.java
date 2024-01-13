package net.javaguides.springboot.backend.repository;

import net.javaguides.springboot.backend.model.Administrator;
import net.javaguides.springboot.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
