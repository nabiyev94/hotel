package net.javaguides.springboot.backend.database;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.*;
import net.javaguides.springboot.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.GarbageCollectorMXBean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FillDatabase {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    private final String[] firstNames = new String[]{"rawan", "fatema", "sarah", "john", "michael"};
    private final String[] lastNames = new String[]{"mustafa", "handi", "othman", "wesly", "petra"};

    public void fillDatabaseTable(){
        fillAdministratorTable();
        fillCategoryTable();
        fillRoomTable();
        fillCustomerTable();
        fillBookTable();
        fillReviewTable();
    }


    public void fillAdministratorTable() {

        List<String> administratorEmailAdress = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            String emailAdress = "administrator" + i;

            emailAdress = emailAdress + "@gmail.com";
            administratorEmailAdress.add(emailAdress);
        }

        List<String> administratorPassword = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            String password = "password";
            password = password + i;
            administratorPassword.add(password);
        }

        LocalDate date1 = LocalDate.of(1996, 1,10);
        LocalDate date2 = LocalDate.of(1994,10,31);
        LocalDate date3 = LocalDate.of(1997, 9,29);
        LocalDate date4 = LocalDate.of(1978, 8,15);
        LocalDate date5 = LocalDate.of(1986,12,10);
        LocalDate[] date = new LocalDate[] {date1, date2, date3, date4, date5};

        int firstName = new Random().nextInt(firstNames.length);
        int lastName = new Random().nextInt(lastNames.length);
        int birthDate = new Random().nextInt(date.length);

        for(int i = 0; i < 10; i++){
            Administrator administrator = new Administrator();
            firstName = new Random().nextInt(firstNames.length);
            lastName = new Random().nextInt(lastNames.length);
            birthDate = new Random().nextInt(date.length);

            administrator.setFirstName(firstNames[firstName]);
            administrator.setLastName(lastNames[lastName]);
            administrator.setBirthDate(date[birthDate]);
            administrator.setPassword(administratorPassword.get(i));
            administrator.setEmail(administratorEmailAdress.get(i));
            this.administratorRepository.save(administrator);

        }

    }




    public void fillCustomerTable() {
        List<String> customerEmailAdress = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String emailAdress = "customer" + i;
            //  emailAdress = emailAdress + i;
            emailAdress = emailAdress + "@gmail.com";
            customerEmailAdress.add(emailAdress);
        }

        List<String> customerPassword = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String password = "password";
            password = password + i;
            customerPassword.add(password);
        }

        LocalDate date1 = LocalDate.of(1996, 1, 10);
        LocalDate date2 = LocalDate.of(1994, 10, 31);
        LocalDate date3 = LocalDate.of(1997, 9, 29);
        LocalDate date4 = LocalDate.of(1978, 8, 15);
        LocalDate date5 = LocalDate.of(1986, 12, 10);
        LocalDate[] date = new LocalDate[]{date1, date2, date3, date4, date5};

        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            int firstName = new Random().nextInt(firstNames.length);
            int lastName = new Random().nextInt(lastNames.length);
            int birthDate = new Random().nextInt(date.length);
            int Password = new Random().nextInt(customerPassword.size());
            // int email = new Random().nextInt(customerEmailAdress.size());
            String email = customerEmailAdress.get(i);

            customer.setFirstName(firstNames[firstName]);
            customer.setLastName(lastNames[lastName]);
            customer.setBirthDate(date[birthDate]);
            customer.setPassword(customerPassword.get(Password));
            customer.setEmail(email);
            this.customerRepository.save(customer);


        }
    }



    public void fillCategoryTable() {
        String[] categoryNames = new String[] {"category1", "category2", "category3", "category4", "category5"};
        String[] descriptions = new String[] { "normal", "cheap", "acceptable", "VIP", "high VIP"};
        Integer[] capacities = new Integer[] {4, 2, 5, 6, 1, 3};

        for(int i = 0; i < 10; i++){
            Category category = new Category();
            int name = new Random().nextInt(categoryNames.length);
            int description = new Random().nextInt(descriptions.length);
            int capacity = new Random().nextInt(capacities.length);

            category.setName(categoryNames[name]);
            category.setDescription(descriptions[description]);
            category.setCapacity(capacities[capacity]);

            this.categoryRepository.save(category);
        }
    }



    public void fillRoomTable() {
        List<Integer> categories = new ArrayList<>();
        List<Category> listCategories = this.categoryRepository.findAll();
        for (int i = 0; i < listCategories.size(); ++i) {
            categories.add(listCategories.get(i).getCategoryId());
        }

        List<Long> administrators = new ArrayList<>();
        List<Administrator> listAdministrator = this.administratorRepository.findAll();
        for (int i = 0; i < listAdministrator.size(); ++i) {
            administrators.add(listAdministrator.get(i).getAdministratorId());
        }
        for (int i = 0; i < 100; i++) {
            Room room = new Room();
            if (!categories.isEmpty() && !administrators.isEmpty()) {
                int idxOfCategory = new Random().nextInt(categories.size());
                int id = new Random().nextInt(administrators.size());
                room.assignCategory(this.categoryRepository.findById(categories.get(idxOfCategory)).get());
                room.assignAdministrator(this.administratorRepository.findById(administrators.get(id)).get());
            } else {
                throw new ResourceNotFoundException("Either category list or administrator list is empty.");
            }

            room.setPrice(20.0);

          //  this.customerRepository.save(customer);
            this.roomRepository.save(room);
        }
    }



    public void fillBookTable() {

        List<Integer> customers = new ArrayList<>();
        List<Customer> listCustomers = this.customerRepository.findAll();

        for(int i = 0; i < listCustomers.size(); ++i){
            customers.add(listCustomers.get(i).getCustomerId());
        }

        int month = 1;
        int day = 0;

        List<Room> listRooms = this.roomRepository.findAll();
        List<Long> rooms = new ArrayList<>();

        for(int i = 0; i < listRooms.size(); ++i){
            rooms.add(listRooms.get(i).getRoomId());
        }

        for (int i = 1; i < 10; ++i) {
            Book book = new Book();
            ++day;
            LocalDate checkInDate = LocalDate.of(2023, month, day);
            day += 5;
            LocalDate checkOUtDate = LocalDate.of(2023, month, day);
            if (day >= 25) {
                day = 0;
                ++month;
            }

            int customerIdx = new Random().nextInt(customers.size());
            int roomIdx = new Random().nextInt(rooms.size());

            Customer customer = this.customerRepository.findById(customers.get(customerIdx)).get();
            Room room = this.roomRepository.findById(rooms.get(roomIdx)).get();
            book.setRoom(room);
            book.setCustomer(customer);
            book.setCheckInDate(checkInDate);
            book.setCheckOutDate(checkOUtDate);

            this.bookRepository.save(book);

        }
    }

    public void fillReviewTable() {
        String[] reviewTxts = new String[]{"good", "not really good", "bad", "super"};
        List<Room> rooms = this.roomRepository.findAll();
        List<Customer> customers = this.customerRepository.findAll();

        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Review review = new Review();
            int txt = random.nextInt(reviewTxts.length);
            review.setReviewTxt(reviewTxts[txt]);

            if (!rooms.isEmpty()) {
                int roomIdx = random.nextInt(rooms.size());
                Room room = rooms.get(roomIdx);
                review.setRoom(room);
            }

            if (!customers.isEmpty()) {
                int customerIdx = random.nextInt(customers.size());
                Customer customer = customers.get(customerIdx);
                review.setCustomer(customer);
            }

            review.setDate(LocalDate.now());

            this.reviewRepository.save(review);
        }
    }

    public void deleteAllData(){
        this.roomRepository.deleteAll();
        this.customerRepository.deleteAll();
        this.categoryRepository.deleteAll();
        this.bookRepository.deleteAll();
        this.administratorRepository.deleteAll();
        this.reviewRepository.deleteAll();
    }


}

