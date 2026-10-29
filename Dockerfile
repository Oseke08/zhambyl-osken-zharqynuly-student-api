# Stage 1: build the Spring Boot JAR with Gradle
FROM eclipse-temurin:21-jdk AS build
WORKDIR /workspace
COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew
COPY src ./src
RUN ./gradlew --no-daemon clean bootJar -x test

# Stage 2: minimal runtime image with only the JAR
FROM eclipse-temurin:21-jre
WORKDIR /app
RUN useradd --system --uid 1001 appuser
COPY --from=build /workspace/build/libs/*.jar app.jar
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
