🛒 CloneFlipCart – Item Management REST API

A simple Spring Boot RESTful API that simulates a basic e-commerce backend (like Flipkart) for managing items using in-memory storage.

This project demonstrates clean architecture, REST principles, and CRUD operations without using a database.

📌 Features

Create new items

Get item by ID

Get all items

Update item details

Delete item

Input validation with proper error messages

In-memory data storage (ArrayList)

Clean layered architecture (Controller, Service, Repository)

🧰 Tech Stack

Java 21

Spring Boot

Spring Web

Spring Validation

Maven

REST API

In-Memory Storage (ArrayList)

📂 Project Structure
com.clone.CloneFlipCart
│
├── controller
│   └── ItemController.java
│
├── model
│   └── Item.java
│
├── repository
│   └── ItemRepository.java
│
├── service
│   └── ItemService.java
│
├── exception
│   ├── ItemNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── CloneFlipCartApplication.java

▶️ How to Run the Application

Clone the repository

git clone <repository-url>


Open the project in IntelliJ IDEA / Eclipse

Make sure Java 21 is installed

Run the application:

CloneFlipCartApplication.java


Server will start at:

http://localhost:8080

📦 Item Model
{
  "id": 1,
  "name": "iPhone 15",
  "category": "Electronics",
  "price": 79999,
  "description": "Apple flagship smartphone"
}

🔗 API Endpoints
➕ Create Item

POST /api/items

Request Body:

{
  "name": "iPhone 15",
  "category": "Electronics",
  "price": 79999,
  "description": "Apple flagship smartphone"
}


Response:

201 CREATED

📄 Get All Items

GET /api/items

Response:

200 OK (with items)

204 NO CONTENT (if empty)

🔍 Get Item by ID

GET /api/items/{id}

Example:

GET /api/items/1


Response:

200 OK

404 NOT FOUND

🔄 Update Item

PUT /api/items/{id}

Request Body:

{
  "name": "iPhone 15 Pro",
  "category": "Electronics",
  "price": 84999,
  "description": "Updated Apple smartphone"
}


Response:

200 OK

404 NOT FOUND

❌ Delete Item

DELETE /api/items/{id}

Response:

200 OK

404 NOT FOUND

✅ Input Validation

The following validations are applied:

Field	Validation
name	Must not be blank
category	Must not be blank
price	Must be positive
description	Must not be blank

Validation errors return:

400 BAD REQUEST

⚠️ Notes & Limitations

No database is used

Data is lost when the application restarts
