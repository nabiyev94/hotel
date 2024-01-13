package net.javaguides.springboot.backend.model.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@Document
public class CustomerMongo {

    @Id
    private String customerMongoId;

    private String password;
    private String firstName;
    private String lastName;
    private String customerEmail;
    private LocalDate birthDate;





    public CustomerMongo() {
    }

    public CustomerMongo( String password, String firstName, String lastName, String customerEmail, LocalDate birthDate) {
      //  this.customerMongoId = customerMongoId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
        this.birthDate = birthDate;
    }

    public String getCustomerMongoId() {
        return customerMongoId;
    }

    public void setCustomerMongoId(String customerMongoId) {
        this.customerMongoId = customerMongoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



}
