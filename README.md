# Patient Management System

A microservices-based backend system for managing patient records, built with Spring Boot.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA** — ORM and repository layer
- **H2 Database** — In-memory database for development
- **Hibernate** — DDL management and query execution
- **Maven** — Build and dependency management


## Getting Started

**Prerequisites:** Java 21, Maven

**Run the application:**
```bash
cd patient-service
./mvnw spring-boot:run
```

The service starts on `http://localhost:4000`

**H2 Console** (dev only): `http://localhost:4000/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `admin`
- Password: `admin`
