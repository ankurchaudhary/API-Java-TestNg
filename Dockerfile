FROM openjdk:11-jre-slim
WORKDIR /home/selenium-docker
ADD target/docker-resources .
ENTRYPOINT java -cp "libs/*" \
           org.testng.TestNG \
           src/test/resources/TestNg.xml