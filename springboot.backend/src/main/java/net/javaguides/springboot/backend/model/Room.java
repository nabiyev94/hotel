package net.javaguides.springboot.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity // => to make the class as jpa entity
@Table(name = " room ") // to provide table details, just give table name to this class
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;
    @Column(name = " price ")
    private double price;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name= "administratorId", referencedColumnName = "administratorId")//, referencedColumnName = "id")
    private Administrator administrator;

    @ManyToOne
    @JoinColumn(name= "categoryId", referencedColumnName = "categoryId")
    private Category category;



    @ManyToMany
    @JoinTable(
            name = "customerList",
            joinColumns = @JoinColumn(name = "roomId"),
            inverseJoinColumns = @JoinColumn(name = "customerId")
    )
    private List<Customer> customersList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Room( double price) {
        this.price = price;
    }

    public Room() {
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public Category getCategory() {
        return category;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public void assignAdministrator(Administrator administrator) {
        this.administrator = administrator;

    }
    public void assignCategory(Category category) {
        this.category = category;
    }

}
