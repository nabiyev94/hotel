package com.imse.hotel.fillingdatabase;

import com.imse.hotel.sql.model.*;
import com.imse.hotel.sql.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class FillingDataBase {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AdminstratorRepository adminstratorRepository;

    @Autowired
    private BookingCartRepository bookingCartRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    @Autowired
    private RoomReviewingRepository roomReviewingRepository;


    private final String[] firstNames = new String[] {"wael", "maxi", "aron", "jada", "jodi", "layla", "yara"};
    private final String[] lastNames = new String[] {"kadon", "stephan", "sawa", "nara", "maximilian", "naroto", "myson"};




    public void fillDataBaseTables(){
        fillCustomerTable();
        fillCategoryTable();
        fillAdminTable();
        fillRoomTable();
        fillBookedRoomTable();
        fillReviewTable();
    }

    public void fillCustomerTable(){

        List<String> emailAdresses = new ArrayList<>();
        for(int i = 0; i < 20; ++i){
            String emailAdress = "customer";
            emailAdress += i;
            emailAdress += "@gmail.com";
            emailAdresses.add(emailAdress);
        }

        List<String> passwords = new ArrayList<>();
        for(int i = 0; i < 20; ++i){
            String pass = "password";
            pass += i;
            passwords.add(pass);
        }


        LocalDate date1 = LocalDate.of(1990,10,10);
        LocalDate date2 = LocalDate.of(2000,10,10);
        LocalDate date3 = LocalDate.of(1995,10,10);
        LocalDate date4 = LocalDate.of(1975,10,10);
        LocalDate date5 = LocalDate.of(1985,10,10);
        List<Date> birthdays = new ArrayList<>();
        LocalDate[] dates = new LocalDate[] {date1, date2, date3, date4, date5};

        Double[] roomPrices = new Double[]{1500.0, 2000.0, 1000.0, 1700.0, 500.0, 985.0};
        Integer[] listOfQuantities = new Integer[] {4, 2, 5, 6, 1, 3};

        Customer customer = new Customer();
        BookingCart bookingCart = new BookingCart();
        int temp = 1985;
        for(int i = 0 ; i < 20; ++i){
            customer = new Customer();
            bookingCart = new BookingCart();

            int firstCustomerName = new Random().nextInt(firstNames.length);
            int lastCustomerName = new Random().nextInt(lastNames.length);
            int customerEmailAdress = new Random().nextInt(emailAdresses.size());
            int customerPassword = new Random().nextInt(passwords.size());
            int customerBirthday = new Random().nextInt(dates.length);
            int price = new Random().nextInt(roomPrices.length);
            int quantity = new Random().nextInt(listOfQuantities.length);

            bookingCart.setTotalPrice(roomPrices[price]);
            bookingCart.setRoomQuantity(listOfQuantities[quantity]);

            customer.setFirstName(firstNames[firstCustomerName]);
            customer.setLastName(lastNames[lastCustomerName]);
            customer.setCutomerEmailAdress(emailAdresses.get(customerEmailAdress));
            customer.setPassword(passwords.get(customerPassword));
            customer.setBirthday(dates[customerBirthday]);
            customer.setBookingCart(bookingCart);

            this.bookingCartRepository.save(bookingCart);
            this.customerRepository.save(customer);
        }
    }

    public void fillCategoryTable(){
        String[] catNames = new String[] {"cat1", "cat2", "cat3", "cat4", "cat5"};
        Integer[] capcaties = new Integer[] {4, 2, 5, 6, 1, 3};
        String[] descriptions = new String[] {"VIP", "normal", "acceptable", "cheap", "high VIP"};

        Category category = new Category();
        for(int i = 0; i < 5; ++i){
            category = new Category();

            int indexName = new Random().nextInt(catNames.length);
            int indexCap = new Random().nextInt(capcaties.length);
            int indexDep = new Random().nextInt(descriptions.length);

            category.setName(catNames[indexName]);
            category.setCapacity(capcaties[indexCap]);
            category.setDespcription(descriptions[indexDep]);

            this.categoryRepository.save(category);
        }
    }


    public void fillRoomTable(){

        boolean availability = true;

        List<Integer> listOfCategoriesIDs = new ArrayList<>();
        List<Category> listOfCategories = this.categoryRepository.findAll();

        for(int i = 0; i < listOfCategories.size(); ++i){
            listOfCategoriesIDs.add(listOfCategories.get(i).getCategoryId());
        }


        LocalDate date1 = LocalDate.of(2022,10,10);
        LocalDate date2 = LocalDate.of(2022,5,25);
        LocalDate date3 = LocalDate.of(2022,10,29);
        LocalDate date4 = LocalDate.of(2022, 2,25);
        LocalDate date5 = LocalDate.of(2022,1,1);
        List<Date> birthdays = new ArrayList<>();
        LocalDate[] dates = new LocalDate[] {date1, date2, date3, date4, date5};


        List<Long> listOfAdminsIDs = new ArrayList<>();
        List<Administrator> listOfAdmins = this.adminstratorRepository.findAll();

        for(int i = 0; i < listOfAdmins.size(); ++i){
            listOfAdminsIDs.add(listOfAdmins.get(i).getAdminId());
        }

        Room room = new Room();
        for(int i = 0; i < 20; ++i){
            room = new Room();
            int indexCategoryNumber = new Random().nextInt(listOfCategoriesIDs.size());
            int dateM = new Random().nextInt(dates.length);
            int id = new Random().nextInt(listOfAdminsIDs.size());

            room.setRoomNumber(i);
            room.setAvailable(availability);
            room.setManagedDateByAdmin(dates[dateM]);
            Category category = this.categoryRepository.findById(listOfCategoriesIDs.get(indexCategoryNumber)).get();
            room.setCategory(category);
            Administrator administrator = this.adminstratorRepository.findById(listOfAdminsIDs.get(id)).get();
            room.setAdministrator(administrator);

            this.roomRepository.save(room);
        }

    }



    public void fillAdminTable(){

        List<String> adminEmailAdresses = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            String emailAdress = "admin";
            emailAdress += i;
            emailAdress += "@gmail.com";
            adminEmailAdresses.add(emailAdress);
        }

        List<String> adminPasswords = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            String pass = "pass";
            pass += i;
            adminPasswords.add(pass);
        }

        LocalDate date1 = LocalDate.of(1990,10,10);
        LocalDate date2 = LocalDate.of(2000,10,10);
        LocalDate date3 = LocalDate.of(1995,10,10);
        LocalDate date4 = LocalDate.of(1975,10,10);
        LocalDate date5 = LocalDate.of(1985,10,10);
        List<Date> birthdays = new ArrayList<>();
        LocalDate[] dates = new LocalDate[] {date1, date2, date3, date4, date5};


        int firstName = new Random().nextInt(firstNames.length);
        int lastName = new Random().nextInt(lastNames.length);
        int birthday = new Random().nextInt(dates.length);
        Administrator chef = new Administrator();

        chef.setFirstName(firstNames[firstName]);
        chef.setLastName(lastNames[lastName]);
        chef.setAdminEmail(adminEmailAdresses.get(0));
        chef.setBirthday(dates[birthday]);
        chef.setPassword(adminPasswords.get(0));

        this.adminstratorRepository.save(chef);


        Administrator administrator = new Administrator();

        for(int i = 0; i < 5; ++i){
            administrator = new Administrator();

            firstName = new Random().nextInt(firstNames.length);
            lastName = new Random().nextInt(lastNames.length);
            birthday = new Random().nextInt(dates.length);

            administrator.setFirstName(firstNames[firstName]);
            administrator.setLastName(lastNames[lastName]);
            administrator.setAdminEmail(adminEmailAdresses.get(i));
            administrator.setBirthday(dates[birthday]);
            administrator.setPassword(adminPasswords.get(i));

            administrator.setChef(chef);



            this.adminstratorRepository.save(administrator);
        }

    }




    public void fillReviewTable(){
        //Long[] customerIDs = new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L};
        String[] reviewTexts = new String[] {"good", "not really good", "bad", "super"};

        List<Integer> listOfCustomerIDs = new ArrayList<>();
        List<Customer> listOfCustomers = this.customerRepository.findAll();

        for(int i = 0; i < listOfCustomers.size(); ++i){
            listOfCustomerIDs.add(listOfCustomers.get(i).getCustomerID());
        }


        List<Room> listOfRooms = this.roomRepository.findAll();
        List<Integer> listOfRoomsIDs = new ArrayList<>();

        for(int i = 0; i < listOfRooms.size(); ++i){
            listOfRoomsIDs.add(listOfRooms.get(i).getRoomId());
        }




        RoomReviewing roomReviewing = new RoomReviewing();
        for(int i = 1; i < 21; ++i){
            roomReviewing = new RoomReviewing();
            int customerIdIndex = new Random().nextInt(listOfCustomerIDs.size());
            int roomIndex = new Random().nextInt(listOfRoomsIDs.size());
            //int date = new Random().nextInt(listOfDates.length);

            int textIndex = new Random().nextInt(reviewTexts.length);

            Customer customer = this.customerRepository.findById(listOfCustomerIDs.get(customerIdIndex)).get();
            Room room = this.roomRepository.findById(listOfRoomsIDs.get(roomIndex)).get();
            //Long index = Long.valueOf(i);
            //Room room = this.roomRepository.findById(index).get();

            roomReviewing.setCustomer(customer);
            roomReviewing.setRoom(room);
            roomReviewing.setReviewText(reviewTexts[textIndex]);
            //roomReviewing.setReviewDate(listOfDates[date]);

            this.roomReviewingRepository.save(roomReviewing);
        }

    }



    public void fillBookedRoomTable() {
        //Long[] customerIDs = new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L};

        List<Integer> listOfCustomerIDs = new ArrayList<>();
        List<Customer> listOfCustomers = this.customerRepository.findAll();

        for(int i = 0; i < listOfCustomers.size(); ++i){
            listOfCustomerIDs.add(listOfCustomers.get(i).getCustomerID());
        }

        int month = 1;
        int day = 0;

        BookedRoom bookedRoom = new BookedRoom();

        List<Room> listOfRooms = this.roomRepository.findAll();
        List<Integer> listOfRoomsIDs = new ArrayList<>();

        for(int i = 0; i < listOfRooms.size(); ++i){
            listOfRoomsIDs.add(listOfRooms.get(i).getRoomId());
        }

        for (int i = 1; i < 10; ++i) {
            bookedRoom = new BookedRoom();
            ++day;
            LocalDate checkIn = LocalDate.of(2022, month, day);
            day += 5;
            LocalDate checkOUt = LocalDate.of(2022, month, day);
            if (day >= 25) {
                day = 0;
                ++month;
            }

            int customerIdIndex = new Random().nextInt(listOfCustomerIDs.size());
            int roomIndex = new Random().nextInt(listOfRoomsIDs.size());

            Customer customer = this.customerRepository.findById(listOfCustomerIDs.get(customerIdIndex)).get();
            Room room = this.roomRepository.findById(listOfRoomsIDs.get(roomIndex)).get();
            //Long index = Long.valueOf(i);
            //Room room = this.roomRepository.findById(index).get();

            bookedRoom.setRoom(room);
            bookedRoom.setCustomer(customer);
            bookedRoom.setCheckInDate(checkIn);
            bookedRoom.setCheckOutDate(checkOUt);

            this.bookedRoomRepository.save(bookedRoom);

        }
    }



    public void deleteAllData(){
        this.roomReviewingRepository.deleteAll();
        this.bookingCartRepository.deleteAll();
        this.bookedRoomRepository.deleteAll();
        this.adminstratorRepository.deleteAll();
        this.customerRepository.deleteAll();
        this.roomRepository.deleteAll();
        this.categoryRepository.deleteAll();
    }










}
