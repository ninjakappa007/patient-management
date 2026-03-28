# Patient Management System

A microservices-based backend system for managing patient records, built with Spring Boot.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA** — ORM and repository layer
- **PostgreSQL 16** — Primary database
- **Hibernate** — DDL management and query execution
- **Maven** — Build and dependency management
- **Docker / Podman** — Containerization

## Local Development

**1. Start the database:**
```bash
docker compose up -d db
```

**2. Run the service:**
```bash
cd patient-service
./mvnw spring-boot:run
```

Service runs on `http://localhost:4000`

## Docker Commands

```bash
docker compose up --build          # rebuild and start all services
docker compose up                  # start without rebuilding
docker compose down                # stop all services
docker compose down -v             # stop and clear volumes (resets DB)
docker ps                          # list running containers
docker ps -a                       # list all containers including stopped
docker images                      # list all images
docker logs <container>            # view container logs
docker logs -f <container>         # follow logs in real time
docker stop <container>            # stop a container
docker rm <container>              # remove a container
docker rmi <image>                 # remove an image
docker container prune             # remove all stopped containers
docker image prune                 # remove all unused images
docker exec -it <container> bash   # shell into a running container
```
