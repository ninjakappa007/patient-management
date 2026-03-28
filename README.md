# Patient Management System

A microservices-based backend system for managing patient records, built with Spring Boot.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA** — ORM and repository layer
- **PostgreSQL Database** — Database for development
- **Hibernate** — DDL management and query execution
- **Maven** — Build and dependency management


## Getting Started
To start dev db just install docker or podman and use docker compose file it has all external resources config
patient service starts on `4000`
postgres starts on `5432`
redis starts on `6379`



docker compose down        # stop containers
docker build -t patient-service .  # rebuild image
docker compose up          # start again
docker compose up --build     # build and start together

2:49 pending