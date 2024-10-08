# Use the latest Java 22 JDK slim image
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and configuration files
COPY ./pom.xml ./pom.xml
COPY ./mvnw ./mvnw
COPY ./.mvn ./.mvn

# Resolve project dependencies
RUN ./mvnw dependency:resolve

# Copy the project source code
COPY ./src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/coaching-0.0.1-SNAPSHOT.jar"]
