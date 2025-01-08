# expense-tracker
# Expense Tracker

## Description

The **Expense Tracker** is a Java-based web application built using **Spring Boot**, **Maven**, and **MySQL**. It allows users to manage their expenses by adding categories, tracking their spending, and organizing expenses by user and category.

## Technologies Used

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework used to build the RESTful API.
- **Spring Data JPA**: For database access and interaction with MySQL.
- **MySQL**: Relational database management system to store user and expense data.
- **Maven**: Dependency management and build automation tool.
- **Postman/Insomnia**: API testing tools.

## API Endpoints

### User Management

| HTTP Method | Endpoint                  | Description                  | Request Body                          |
|-------------|---------------------------|------------------------------|---------------------------------------|
| `POST`      | `/api/users/register`     | Register a new user          | `{ "username": "string", "email": "string", "password": "string" }` |
| `GET`       | `/api/users/{username}`   | Get user by username         | N/A                                   |

### Category Management

| HTTP Method | Endpoint                  | Description                   | Request Body                          |
|-------------|---------------------------|-------------------------------|---------------------------------------|
| `POST`      | `/api/categories`         | Add a new category            | `{ "name": "string", "description": "string" }` |
| `GET`       | `/api/categories`         | Get all categories            | N/A                                   |
| `GET`       | `/api/categories/{name}`  | Get a category by its name    | N/A                                   |

### Expense Management

| HTTP Method | Endpoint                                    | Description                                | Request Body                          |
|-------------|---------------------------------------------|--------------------------------------------|---------------------------------------|
| `POST`      | `/api/expenses`                             | Add a new expense                         | `{ "amount": number, "date": "YYYY-MM-DD", "category": "string", "userId": number }` |
| `GET`       | `/api/expenses/user/{userId}`               | Get all expenses for a specific user      | N/A                                   |
| `GET`       | `/api/expenses/user/{userId}/category/{categoryName}` | Get expenses for a user by category | N/A                                   |

## Service Layer

### UserService

The `UserService` class handles business logic related to the **User** entity, such as saving, retrieving, and deleting users.

#### Key Methods:

- **saveUser(User user)**: Saves a new user to the database.
- **findByUsername(String username)**: Retrieves a user by their username.
- **findByEmail(String email)**: Retrieves a user by their email.
- **findById(Long id)**: Retrieves a user by their ID.
- **deleteUser(Long id)**: Deletes a user by their ID.

### CategoryService

The `CategoryService` class handles business logic related to the **Category** entity, including operations such as saving, retrieving, and deleting categories.

#### Key Methods:

- **saveCategory(Category category)**: Saves a new category to the database.
- **findByName(String name)**: Retrieves a category by its name.
- **getAllCategories()**: Fetches all categories from the database.
- **deleteCategory(Long id)**: Deletes a category by its ID.

### ExpenseService

The `ExpenseService` class contains the business logic related to the **Expense** entity. It manages operations like saving, retrieving, and deleting expenses.

#### Key Methods:

- **saveExpense(Expense expense)**: Saves a new expense to the database.
- **findById(Long id)**: Retrieves an expense by its ID.
- **getExpensesByUser(User user)**: Fetches all expenses associated with a specific user.
- **getExpensesByUserAndCategory(User user, Category category)**: Retrieves expenses for a user filtered by category.
- **getExpensesByDateRange(User user, LocalDate startDate, LocalDate endDate)**: Retrieves expenses for a user within a specified date range.
- **deleteExpense(Long id)**: Deletes an expense by its ID.

## Database

### MySQL Database

The project uses **MySQL** to store user, category, and expense data. The database is structured to support the following entities:

- **User**: Stores user credentials and personal information.
- **Category**: Stores expense categories like Food, Entertainment, etc.
- **Expense**: Stores individual expense records, associated with a user and a category.


### Prerequisites

- JDK 11 or later
- MySQL database
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)
