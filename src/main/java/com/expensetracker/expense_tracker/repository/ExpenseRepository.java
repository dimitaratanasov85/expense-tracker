package com.expensetracker.expense_tracker.repository;

import com.expensetracker.expense_tracker.model.Expense;
import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find all expenses for a specific user
    List<Expense> findByUser(User user);

    // Find all expenses for a specific user and category
    List<Expense> findByUserAndCategory(User user, Category category);

    // Find expenses by user and date range
    List<Expense> findByUserAndDateBetween(User user, java.time.LocalDate startDate, java.time.LocalDate endDate);
}
