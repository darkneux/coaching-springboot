FROM openjdk:22-jdk-slim


WORKDIR /app


COPY ./pom.xml ./pom.xml
COPY ./mvnw ./mvnw
COPY ./.mvn ./.mvn


RUN ./mvnw dependency:resolve


COPY ./src ./src


RUN ./mvnw package


EXPOSE 8080


CMD ["java", "-jar", "target/coaching-0.0.1-SNAPSHOT.jar"]
