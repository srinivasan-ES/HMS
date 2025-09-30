# ===========================
# Stage 1: Build the project
# ===========================
FROM maven:3.9.3-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the project and skip tests
RUN mvn clean package -DskipTests

# ===========================
# Stage 2: Run the application
# ===========================
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot app uses
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
