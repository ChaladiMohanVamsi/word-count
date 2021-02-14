# word-count
Web Application to count words.

# Built with
* Java Spring Boot Framework
* Docker

# Running word-count application
* starting docker compose file.
  ```sh
  docker-compose -f playbook/docker-compose.yml up
  ```
* starting docker compose file in detached mode.
  ```sh
  docker-compose -f playbook/docker-compose.yml up -d
  ```
# Accessing Rest Endpoints
* GET localhost:8080/api/word/foo
* PUT localhost:8080/api/word/foo

# Swagger API Documentation available
* [localhost:8080/swagger-ui.html]([localhost:8080/swagger-ui.html)

