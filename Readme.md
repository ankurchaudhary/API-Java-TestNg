To build image and run all tests trigger the following command:

mvn clean package -DskipTests; docker build -t docker/automation:latest .; docker compose up
