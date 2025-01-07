package com.expensetracker.expense_tracker.service;

import com.expensetracker.expense_tracker.model.Category;
import com.expensetracker.expense_tracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Save a new category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Find category by name
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Delete category by ID
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
