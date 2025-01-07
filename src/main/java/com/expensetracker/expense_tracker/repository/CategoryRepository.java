package com.expensetracker.expense_tracker.repository;

import com.expensetracker.expense_tracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Custom query method to find a category by name
    Optional<Category> findByName(String name);
}
