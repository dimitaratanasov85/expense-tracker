package com.expensetracker.expense_tracker.service;

import com.expensetracker.expense_tracker.model.Expense;
import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.model.Category;
import com.expensetracker.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Save a new expense
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Find expense by ID
    public Optional<Expense> findById(Long id) {
        return expenseRepository.findById(id);
    }

    // Get all expenses for a specific user
    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    // Get expenses by user and category
    public List<Expense> getExpensesByUserAndCategory(User user, Category category) {
        return expenseRepository.findByUserAndCategory(user, category);
    }

    // Get expenses by user and date range
    public List<Expense> getExpensesByDateRange(User user, LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByUserAndDateBetween(user, startDate, endDate);
    }

    // Delete expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
