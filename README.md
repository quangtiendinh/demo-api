# Demo Api Application

## Requirements
For building and running the application you need:
- JDK 11
- Docker
- Maven
- IntelliJ

## How to Run
- Clone the project

- Maven build project
```
mvn clean install -DskipTests
```
- Run application using docker-compose
```
docker compose build --no-cache
```
```
docker compose up
```
### Check app running

```shell
http://localhost:9090/api/v1/ping
```

### API documentation

```shell
http://localhost:9090/swagger-ui/index.html
```

### Useful docker-compose commands
- `docker-compose build`
- `docker-compose up -d` (Detached)
- `docker-compose down` (stop)
- `docker-compose restart` (restart the services)