package com.imse.hotel.sql.repository;

import com.imse.hotel.sql.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    public Customer findByCutomerEmailAdress(String cutomerEmailAdress);

}
