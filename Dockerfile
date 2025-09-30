# Stage 1: Build
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /target/*.jar HospitalClient-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
