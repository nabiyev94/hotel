package com.imse.hotel.fillingdatabase;

import com.imse.hotel.nosql.modelmongodb.*;
import com.imse.hotel.nosql.repositorymongodb.*;
import com.imse.hotel.sql.model.*;
import com.imse.hotel.sql.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataMigrating {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMongoDbRepository customerMongoDbRepository;

    @Autowired
    private ReviewingMongoRepository reviewingMongoRepository;

    @Autowired
    private RoomReviewingRepository roomReviewingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMongoDbRepository roomMongoDbRepository;

    @Autowired
    private CategoryMongoDbRepository categoryMongoDbRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AdminstratorRepository adminstratorRepository;

    @Autowired
    private AdminMongoDbRepository adminMongoDbRepository;

    @Autowired
    private BookedRoomsMongoRepository bookedRoomsMongoRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;







    public void migrateData(){

        migrateCustomer();
        migrateCategoryData();
        migrateAdminData();
        migrateRoomData();
        migrateReviewData();
        migrateBookedRoomData();

    }

    public void deleteData(){
        this.mongoTemplate.getDb().drop();
    }

    public void migrateCustomer(){

        List<Customer> listOfCustomers = this.customerRepository.findAll();

        for(int i = 0; i < listOfCustomers.size(); ++i){
            CustomerMongoDb customerMongoDb = new CustomerMongoDb();
            Customer customer = listOfCustomers.get(i);

            customerMongoDb.setFirstName(customer.getFirstName());
            customerMongoDb.setLastName(customer.getLastName());
            customerMongoDb.setPassword(customer.getPassword());
            customerMongoDb.setBirthday(customer.getBirthday());
            customerMongoDb.setCutomerEmailAdress(customer.getCutomerEmailAdress());
            customerMongoDb.setCustomerId(Integer.toString(customer.getCustomerID()));

            this.customerMongoDbRepository.save(customerMongoDb);

        }
    }


    public void migrateCategoryData(){

        List<Category> listOfCategories = this.categoryRepository.findAll();

        for(int i = 0; i < listOfCategories.size(); ++i){
            Category category = listOfCategories.get(i);
            CategoryMongoDb categoryMongoDb = new CategoryMongoDb();

            categoryMongoDb.setCapacity(category.getCapacity());
            categoryMongoDb.setDespcription(category.getDespcription());
            categoryMongoDb.setName(category.getName());
            categoryMongoDb.setCategoryId(Integer.toString(category.getCategoryId()));


            this.categoryMongoDbRepository.save(categoryMongoDb);
        }

    }

    public void migrateAdminData(){

        List<Administrator> listOfAdmins = this.adminstratorRepository.findAll();

        for(int i = 0; i < listOfAdmins.size(); ++i){
            Administrator temp = listOfAdmins.get(i);
            AdminMongoDb admin = new AdminMongoDb();

            admin.setFirstName(temp.getFirstName());
            admin.setLastName(temp.getLastName());
            admin.setBirthday(temp.getBirthday());
            admin.setPassword(temp.getPassword());
            admin.setAdminEmail(temp.getAdminEmail());

            if(temp.getChef() != null){
                admin.setChefId(temp.getChef().getAdminId());
            }

            this.adminMongoDbRepository.save(admin);
        }

    }

    public void migrateRoomData(){

        List<Room> listOfRooms = this.roomRepository.findAll();

        for(int i = 0; i < listOfRooms.size(); ++i){
            Room temp = listOfRooms.get(i);
            RoomMongoDb room = new RoomMongoDb();

            room.setRoomNumber(temp.getRoomNumber());
            room.setAvailable(temp.isAvailable());
            room.setAdminId(temp.getAdministrator().getAdminId());
            room.setCategoryId(Integer.toString(temp.getCategory().getCategoryId()));
            room.setRoomId(Integer.toString(temp.getRoomId()));

            this.roomMongoDbRepository.save(room);
        }

    }



    public void migrateReviewData(){

        List<RoomReviewing> listOfReviews = this.roomReviewingRepository.findAll();

        for(int i = 0; i < listOfReviews.size(); ++i){

            RoomReviewing temp = listOfReviews.get(i);
            RoomReviewingMongoDb review = new RoomReviewingMongoDb();

            Customer customer = this.customerRepository.findById(temp.getCustomer().getCustomerID()).get();
            Room room = this.roomRepository.findById(temp.getRoom().getRoomId()).get();
            Category category = room.getCategory();

            CopyRoomAndCategory copy = new CopyRoomAndCategory();
            copy.setCategoryId(Integer.toString(category.getCategoryId()));
            copy.setRoomId(Integer.toString(room.getRoomId()));

            CustomerRef customerRef = new CustomerRef();
            customerRef.setCustomerId(Integer.toString(customer.getCustomerID()));
            customerRef.setAge(customer.getAge());


            review.setReviewText(temp.getReviewText());
            //review.setCopyRoomAndCategory(copy);
            review.setRoomId(Integer.toString(room.getRoomId()));
            review.setCustomerRef(customerRef);
            review.setReviewDate(temp.getReviewDate());

            this.reviewingMongoRepository.save(review);

        }




    }


    public void migrateBookedRoomData(){

        List<BookedRoom> list = this.bookedRoomRepository.findAll();

        for(int i = 0; i < list.size(); ++i){

            BookedRoom temp = list.get(i);
            BookedRoomMongoDb bookedRoom = new BookedRoomMongoDb();

            Customer customer = this.customerRepository.findById(temp.getCustomer().getCustomerID()).get();
            Room room = this.roomRepository.findById(temp.getRoom().getRoomId()).get();

            CustomerRef customerRef = new CustomerRef();
            customerRef.setCustomerId(Integer.toString(customer.getCustomerID()));
            customerRef.setAge(customer.getAge());


            bookedRoom.setCheckInDate(temp.getCheckInDate());
            bookedRoom.setCheckOutDate(temp.getCheckOutDate());
            bookedRoom.setRoomId(Integer.toString(room.getRoomId()));
            bookedRoom.setCustomerRef(customerRef);

            this.bookedRoomsMongoRepository.save(bookedRoom);

        }










    }











}
