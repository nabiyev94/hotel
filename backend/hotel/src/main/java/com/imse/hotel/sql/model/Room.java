package com.imse.hotel.sql.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "room")
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private int roomNumber;
    private boolean isAvailable = true;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<BookedRoom> bookedRooms = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<RoomReviewing> reviewedRooms = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="adminId", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // dont know what is this :D
    @JsonIgnore
    private Administrator administrator;

    private LocalDate managedDateByAdmin;




    public int getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public List<BookedRoom> getBookedRooms() {
        return bookedRooms;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public void setBookedRooms(List<BookedRoom> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public List<RoomReviewing> getReviewedRooms() {
        return reviewedRooms;
    }

    public void setReviewedRooms(List<RoomReviewing> reviewedRooms) {
        this.reviewedRooms = reviewedRooms;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }


    public LocalDate getManagedDateByAdmin() {
        return managedDateByAdmin;
    }

    public void setManagedDateByAdmin(LocalDate managedDateByAdmin) {
        this.managedDateByAdmin = managedDateByAdmin;
    }
}
