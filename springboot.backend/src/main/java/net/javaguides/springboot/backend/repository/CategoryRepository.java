package net.javaguides.springboot.backend.repository;

import net.javaguides.springboot.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
