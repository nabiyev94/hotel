package net.javaguides.springboot.backend.model.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CategoryMongo {

    @Id
    private String categoryMongoId;
    private String name;
    private long capacity;
    private String description;

    public CategoryMongo() {
    }

    public CategoryMongo(String categoryMongoId, String name, long capacity, String description) {
        this.categoryMongoId = categoryMongoId;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
    }

    public String getCategoryMongoId() {
        return categoryMongoId;
    }

    public void setCategoryMongoId(String categoryMongoId) {
        this.categoryMongoId = categoryMongoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
