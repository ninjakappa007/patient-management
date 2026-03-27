# Patient Management System

A microservices-based backend system for managing patient records, built with Spring Boot.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA** — ORM and repository layer
- **H2 Database** — In-memory database for development
- **Hibernate** — DDL management and query execution
- **Maven** — Build and dependency management

## Project Structure

```
patient-management/
├── patient-service/          # Core microservice for patient operations
│   └── src/main/java/
│       └── com/pm/patientservice/
│           ├── controller/   # REST API endpoints
│           ├── dto/          # Request and response DTOs
│           ├── exception/    # Global exception handling
│           ├── mapper/       # Entity <-> DTO conversion
│           ├── model/        # JPA entities
│           ├── repository/   # Spring Data JPA repositories
│           └── service/      # Business logic
└── api-requests/             # HTTP request samples for testing
```

## Patient Entity

| Field           | Type      | Constraints        |
|-----------------|-----------|--------------------|
| id              | UUID      | Primary Key        |
| name            | String    | Not Null           |
| email           | String    | Not Null, Unique   |
| address         | String    | Not Null           |
| dateOfBirth     | LocalDate | Not Null           |
| registeredDate  | LocalDate | Not Null           |
| gender          | String    | Not Null           |

## API Endpoints

| Method | Endpoint    | Description          |
|--------|-------------|----------------------|
| GET    | /patients   | Get all patients     |
| POST   | /patients   | Create a new patient |

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
