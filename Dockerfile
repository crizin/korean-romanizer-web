FROM eclipse-temurin:17-jdk-alpine
RUN ./gradlew clean bootJar
COPY build/libs/korean-romanizer-web-1.0.0.jar /app/korean-romanizer-web-1.0.0.jar
ENTRYPOINT ["java", "-XX:+UseZGC", "-Xms64m", "-Xmx64m", "-jar", "/app/korean-romanizer-web-1.0.0.jar"]
