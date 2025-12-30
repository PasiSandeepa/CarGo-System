# 🚗 CarGo - Car Rental Management System (Backend)

CarGo is a robust and scalable backend system developed to streamline car rental operations. This system handles everything from vehicle inventory management to customer bookings and payments, replacing manual procedures with a secure and automated digital solution.

---

## 🛠️ Tech Stack & Architecture

This backend is built using modern technologies to ensure high performance and maintainability:

* **Framework:** Spring Boot (Java)
* **Database:** MySQL
* **ORM:** Spring Data JPA / Hibernate
* **Mapping:** ModelMapper / Lombok
* **Security:** CORS Configuration for Cross-Origin requests
* **Architecture:** Layered Architecture (Controller -> Service -> Repository)

---

## ✨ Key Features

- **Car Management:** CRUD operations for vehicle fleet tracking.
- **Customer Management:** Secure handling of customer profiles and data.
- **Booking Engine:** Real-time car availability and booking logic.
- **Payment Integration:** Managing transaction records and payment statuses.
- **Notifications:** System for handling alerts and updates.

---

## 📂 Project Structure

```text
src/main/java/edu/icet/
├── config/         # Bean & CORS configurations
├── controller/     # REST API Endpoints
├── model/
│   ├── dto/        # Data Transfer Objects (Request/Response)
│   └── entity/     # Database Entities
├── repository/     # Data Access Layer (JPA)
└── service/        # Business Logic Layer
🚀 How to Run Locally
Clone the repository:

Bash

git clone [https://github.com/PasiSandeepa/CarGo-System.git](https://github.com/PasiSandeepa/CarGo-System.git)](https://github.com/PasiSandeepa/CarGo-System.git)
Database Setup:

Create a database named cargo_db (or as specified in application.yml).

Update src/main/resources/application.yml with your MySQL username and password.

Build & Run:

Open the project in IntelliJ IDEA.

Run the CarGoApplication class.

📞 Contact
Developed by: Pasi Sandeepa

Project Objective: Replacing outdated manual car rental procedures with a user-friendly digital system.
