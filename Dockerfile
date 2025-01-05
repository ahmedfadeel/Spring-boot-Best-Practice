FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} swagger.jar

ENTRYPOINT ["java", "-jar", "/swagger.jar"]

EXPOSE 8002
