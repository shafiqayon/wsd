# Use Maven to build the application
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use an OpenJDK runtime as the base image for the final container
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/ayon-0.0.1-SNAPSHOT.war /app/ayon-0.0.1-SNAPSHOT.war

# Expose the port that the Spring Boot application listens on
EXPOSE 8080

## Set environment variables for MySQL connection
#ENV MYSQL_HOST=localhost
#ENV MYSQL_PORT=3306
#ENV MYSQL_DATABASE=wsd
#ENV MYSQL_USER=root
#ENV MYSQL_PASSWORD=password

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/ayon-0.0.1-SNAPSHOT.war"]