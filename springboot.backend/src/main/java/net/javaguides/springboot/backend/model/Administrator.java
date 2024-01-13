package net.javaguides.springboot.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long administratorId;
    @Column(name = " password ")
    private String password;
    @Column(name = " firstName ")
    private String firstName;
    @Column(name = " lastName ")
    private String lastName;
    @Column(name = " email ")
    private String email;
    @Column(name = " birthDate ")
    private LocalDate birthDate;
    @JsonIgnore
    @OneToMany(mappedBy = "administrator")
    private List<Room> rooms = new ArrayList<>();

    public Administrator(String firstName, String lastName,String email, LocalDate birthDate, String password) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Administrator(long administratorId, String password, String firstName, String lastName, String email, LocalDate birthDate) {
        this.administratorId = administratorId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Administrator() {
    }

    public long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(long administratorId) {
        this.administratorId = administratorId;
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
