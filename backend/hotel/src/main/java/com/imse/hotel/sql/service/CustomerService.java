package com.imse.hotel.sql.service;

import com.imse.hotel.sql.model.Customer;
import com.imse.hotel.sql.model.Room;
import com.imse.hotel.sql.model.RoomReviewing;
import com.imse.hotel.sql.repository.BookingCartRepository;
import com.imse.hotel.sql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingCartRepository bookingCartRepository;


    public Customer registCustomer(Customer tempCustomer) throws Exception {


        this.bookingCartRepository.save(tempCustomer.getBookingCart());

        return this.customerRepository.save(tempCustomer);
        /*
        if(findByEmailAdress(tempCustomer.getCustomerEmailAdress()) == null){
            return this.customerRepository.save(tempCustomer);
        }
        else{
            throw new Exception("ist invalid");
        }*/
    }

    public Customer getCostomer(int id){
        return this.customerRepository.findById(id).get();
    }


    public Customer findByEmailAdress(String cutomerEmailAdress){
        return this.customerRepository.findByCutomerEmailAdress(cutomerEmailAdress);
    }

    public Customer findCustomerByEmailAdress(String emailAdress) throws Exception {



        if(findByEmailAdress(emailAdress) != null)
            return this.customerRepository.findByCutomerEmailAdress(emailAdress);
        else
            throw new Exception("not exist");
    }


    public List<Customer> getAllCustomers(){

        return this.customerRepository.findAll();

    }

    public void deleteCustomerFromDb(int id){
        Customer customer = this.customerRepository.findById(id).get();
        this.customerRepository.delete(customer);
    }


    public List<Room> getList(int id){
        Customer customer = this.customerRepository.findById(id).get();

        List<RoomReviewing> temp = customer.getReviewedRooms();
        List<Room> roomList = new ArrayList<>();

        for(int i = 0; i < temp.size(); ++i){
            Room room = temp.get(i).getRoom();
            roomList.add(room);
        }

        return roomList;
    }

}
