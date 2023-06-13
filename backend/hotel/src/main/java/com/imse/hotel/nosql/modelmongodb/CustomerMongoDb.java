package com.imse.hotel.nosql.modelmongodb;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Document
public class CustomerMongoDb {

    @Id
    private String customerId;

    private String firstName;
    private String lastName;

    @Indexed
    private String cutomerEmailAdress;

    private String password;
    private LocalDate birthday;
    private int age;

    //@JsonIgnore
    private BookingsCartMongoDb cartMongoDb;

    public CustomerMongoDb() {
    }

    public CustomerMongoDb(String firstName, String lastName, String cutomerEmailAdress, String password, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cutomerEmailAdress = cutomerEmailAdress;
        this.password = password;
        this.birthday = birthday;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCutomerEmailAdress() {
        return cutomerEmailAdress;
    }

    public void setCutomerEmailAdress(String cutomerEmailAdress) {
        this.cutomerEmailAdress = cutomerEmailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {

        this.birthday = birthday;
        LocalDate localDate = LocalDate.now();
        this.age = Period.between(this.birthday, localDate).getYears();
    }

    public int getAge() {
        return age;
    }


    public BookingsCartMongoDb getCartMongoDb() {
        return cartMongoDb;
    }

    public void setCartMongoDb(BookingsCartMongoDb cartMongoDb) {
        this.cartMongoDb = cartMongoDb;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
