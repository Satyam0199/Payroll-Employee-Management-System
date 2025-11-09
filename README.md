# 🧾 Payroll Management System

The **Payroll Management System** is a Spring Boot-based web application designed to manage employee information, departments, and payroll details in an organization.  
This project follows a clean **layered architecture** — separating responsibilities into Controller, Service, Repository, and Entity layers for better maintainability and scalability.

---

## 🚀 Features

- Add and manage **Departments**
- Add and manage **Employees**
- Manage **Payrolls** (employee salary records)
- Retrieve data using RESTful APIs
- Unified **API Response structure** using `ApiResponse` class
- Integrated with **MySQL Database**
- Proper use of **JPA relationships** (`@OneToMany`, `@ManyToOne`)
- Clean and modular **Spring Boot structure**

---

## 🧩 Project Architecture

The project follows **4 main layers**:

| Layer | Description |
|--------|--------------|
| **Controller** | Handles incoming HTTP requests and returns responses. |
| **Service** | Contains business logic for processing data between Controller and Repository. |
| **Repository** | Interacts with the database using Spring Data JPA. |
| **Entity** | Represents the database tables as Java objects. |

---

## 🏗️ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL Database**
- **Lombok** (optional)
- **Postman** (for API testing)
- **Maven** (for dependency management)

---

## 📦 Project Structure



---

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/Payroll-Management-System.git
cd Payroll-Management-System

