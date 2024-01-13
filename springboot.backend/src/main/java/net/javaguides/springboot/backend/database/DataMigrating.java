package net.javaguides.springboot.backend.database;

import net.javaguides.springboot.backend.model.*;
import net.javaguides.springboot.backend.model.mongo.*;
import net.javaguides.springboot.backend.repository.*;
import net.javaguides.springboot.backend.repository.mongoRepository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class DataMigrating {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMongoRepository roomMongoRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMongoRepository customerMongoRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMongoRepository reviewMongoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMongoRepository bookMongoRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private AdministratorMongoRepository administratorMongoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMongoRepository categoryMongoRepository;

    public void migrateData(){
        migrateCustomerData();
        migrateCategoryData();
        migrateAdministratorData();
        migrateRoomData();
        migrateReviewData();
        migrateBookeData();

    }





      private void migrateCustomerData() {
        List<Customer> listOfCustomers = this.customerRepository.findAll();

        for (int i = 0; i < listOfCustomers.size(); ++i) {
            Customer customer = listOfCustomers.get(i);
            CustomerMongo customerMongo = new CustomerMongo();

            customerMongo.setFirstName(customer.getFirstName());
            customerMongo.setLastName(customer.getLastName());
            customerMongo.setPassword(customer.getPassword());
            customerMongo.setBirthDate(customer.getBirthDate());
            customerMongo.setCustomerEmail(customer.getEmail());

            customerMongo.setCustomerMongoId(Integer.toString(customer.getCustomerId()));

            this.customerMongoRepository.save(customerMongo);
        }
        
    }

    private void migrateCategoryData() {

        List<Category> listOfCategories = this.categoryRepository.findAll();

        for(int i = 0; i < listOfCategories.size(); ++i){
            Category category = listOfCategories.get(i);
            CategoryMongo categoryMongo = new CategoryMongo();

            categoryMongo.setCapacity(category.getCapacity());
            categoryMongo.setDescription(category.getDescription());
            categoryMongo.setName(category.getName());
            categoryMongo.setCategoryMongoId(Integer.toString(category.getCategoryId()));

            this.categoryMongoRepository.save(categoryMongo);
        }
    }

    private void migrateAdministratorData() {

        List<Administrator> listOfAdmins = this.administratorRepository.findAll();

        for(int i = 0; i < listOfAdmins.size(); ++i){
            Administrator adm = listOfAdmins.get(i);
            AdministratorMongo administrator = new AdministratorMongo();

            administrator.setFirstName(adm.getFirstName());
            administrator.setLastName(adm.getLastName());
            administrator.setBirthDate(adm.getBirthDate());
            administrator.setPassword(adm.getPassword());
            administrator.setEmail(adm.getEmail());
            administrator.setAdministratorMongoId(Long.toString(adm.getAdministratorId()));

            this.administratorMongoRepository.save(administrator);
        }
    }



    private void migrateRoomData() {
            List<Room> listOfRooms = this.roomRepository.findAll();

            for (int i = 0; i < listOfRooms.size(); ++i) {
                Room room = listOfRooms.get(i);
                RoomMongo roomMongo = new RoomMongo();
                if (room.getCategory() != null) {
                    roomMongo.setCategoryMongoId(Long.toString(room.getCategory().getCategoryId()));
                }
                if (room.getAdministrator() != null) {
                    roomMongo.setAdminId(Long.toString(room.getAdministrator().getAdministratorId()));

                }


                roomMongo.setPrice(Double.toString(room.getPrice()));
                roomMongo.setRoomMongoID(Long.toString(room.getRoomId()));

                this.roomMongoRepository.save(roomMongo);
            }
        }


    private void migrateReviewData() {

        List<Review> listOfReviews = this.reviewRepository.findAll();

        for(int i = 0; i < listOfReviews.size(); ++i){

            Review review = listOfReviews.get(i);
            ReviewMongo reviewMongo = new ReviewMongo();

            Customer customer = this.customerRepository.findById(review.getCustomer().getCustomerId()).get();
            Room room = this.roomRepository.findById(review.getRoom().getRoomId()).get();
            if (room.getCategory() != null) {
                Category category = room.getCategory();
                CopyRoomAndCategory copyRoomAndCategory = new CopyRoomAndCategory();
                copyRoomAndCategory.setCategoryMongoId(Integer.toString(category.getCategoryId()));
                copyRoomAndCategory.setRoomMongoID(Long.toString(room.getRoomId()));
            }
            if(customer.getCustomerId() != 0){

            CustomerMongo customerMongo = new CustomerMongo();
            customerMongo.setCustomerMongoId(Integer.toString(customer.getCustomerId()));
            customerMongo.setFirstName(customer.getFirstName());


            reviewMongo.setReviewTxt(review .getReviewTxt());
            reviewMongo.setRoomMongoID(Long.toString(room.getRoomId()));
            reviewMongo.setCustomerMongoId(Integer.toString(customer.getCustomerId()));
            reviewMongo.setDate(review.getDate());}

            this.reviewMongoRepository.save(reviewMongo);

        }

    }

    private void migrateBookeData() {


        List<Book> list = this.bookRepository.findAll();

        for (int i = 0; i < list.size(); ++i) {

            Book book = list.get(i);
            BookMongo bookMongo = new BookMongo();

            Customer customer = this.customerRepository.findById(book.getCustomer().getCustomerId()).get();
            Room room = this.roomRepository.findById(book.getRoom().getRoomId()).get();

            bookMongo.setCheckInDate(book.getCheckInDate());
            bookMongo.setCheckOutDate(book.getCheckOutDate());
            bookMongo.setRoomMongoID(Long.toString(room.getRoomId()));
            bookMongo.setCustomerMongoId(Integer.toString(customer.getCustomerId()));
            bookMongo.setBookMongoId(Long.toString(book.getBookingId()));

            this.bookMongoRepository.save(bookMongo);
        }
    }



    public void deleteData(){
        this.mongoTemplate.getDb().drop();
    }










}
