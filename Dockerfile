FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew
RUN ./gradlew --no-daemon build -x test || true

COPY . .
RUN ./gradlew --no-daemon clean build -x test

# ===== Runtime stage =====
FROM eclipse-temurin:17-jre
WORKDIR /app

ENV TZ=America/Chicago
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

COPY --from=build /app/build/libs/*.jar app.jar

CMD ["sh", "-c", "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"]
