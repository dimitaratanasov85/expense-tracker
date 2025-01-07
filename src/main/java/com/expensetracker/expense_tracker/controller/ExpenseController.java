package com.expensetracker.expense_tracker.controller;

import com.expensetracker.expense_tracker.model.Expense;
import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.model.Category;
import com.expensetracker.expense_tracker.service.ExpenseService;
import com.expensetracker.expense_tracker.service.UserService;
import com.expensetracker.expense_tracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    // Add a new expense
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.saveExpense(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    // Get expenses by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUser(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Expense> expenses = expenseService.getExpensesByUser(user.get());
        return ResponseEntity.ok(expenses);
    }

    // Get expenses by user ID and category name
    @GetMapping("/user/{userId}/category/{categoryName}")
    public ResponseEntity<List<Expense>> getExpensesByUserAndCategory(@PathVariable Long userId, @PathVariable String categoryName) {
        Optional<User> user = userService.findById(userId);
        Optional<Category> category = categoryService.findByName(categoryName);

        if (user.isEmpty() || category.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Expense> expenses = expenseService.getExpensesByUserAndCategory(user.get(), category.get());
        return ResponseEntity.ok(expenses);
    }
}
