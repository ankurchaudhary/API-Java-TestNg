To build image and run all tests use:

mvn clean package -DskipTests; docker build -t docker/automation:latest .; docker compose up
