FROM maven:4.0.0-rc-5-eclipse-temurin-21-noble AS builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM gcr.io/distroless/java21-debian13
COPY --from=builder /app/target/*.jar /usr/local/lib/app.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]