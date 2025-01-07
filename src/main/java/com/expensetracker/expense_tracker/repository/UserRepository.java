package com.expensetracker.expense_tracker.repository;

import com.expensetracker.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find a user by username
    Optional<User> findByUsername(String username);

    // Custom query method to find a user by email
    Optional<User> findByEmail(String email);
}
