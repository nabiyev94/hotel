package net.javaguides.springboot.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private long capacity;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Room> rooms = new ArrayList<>();

    public Category() {
    }

    public Category(int categoryId, String name, long capacity, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
    }

    public Category(String description, String name, long capacity ) {
        this.description = description;
        this.name = name;
        this.capacity = capacity;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
