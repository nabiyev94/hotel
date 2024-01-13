package net.javaguides.springboot.backend.model.mongo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@Document
public class AdministratorMongo {
    @Id
    private String administratorMongoId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;

    public AdministratorMongo() {
    }

    public AdministratorMongo(String administratorMongoId, String password, String firstName, String lastName, String email, LocalDate birthDate) {
        this.administratorMongoId = administratorMongoId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getAdministratorMongoId() {
        return administratorMongoId;
    }

    public void setAdministratorMongoId(String administratorMongoId) {
        this.administratorMongoId = administratorMongoId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
