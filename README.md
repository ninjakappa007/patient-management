# Patient Management System

A microservices-based backend system for managing patient records, built with Spring Boot.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA** — ORM and repository layer
- **PostgreSQL Database** — Database for development
- **Hibernate** — DDL management and query execution
- **Maven** — Build and dependency management
- **Synchronous Communication** — GRPC
- **Asynchronous Communication** — Kafka
- **Queue Service** — SQS/Redis

## Getting Started

To start development use docker or podman and use docker-compose file.

```bash
docker compose down          # stop containers
docker build -t patient-service .  # rebuild image
docker compose up            # start again
docker compose up --build    # build and start together
docker image prune -f        # delete untagged images
```
## Complete Architecture 
![Example Image](/micro-service.png)

## Notification Service
![Example Image](/notification-service.png)


Self Notes :
1. use ElasticMQ for replacement of SQS in local env using docker compose
2. implement api gateway with auth service and block access to downstream services 
3. global access to proto files, for grpcs
4. 