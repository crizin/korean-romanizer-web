FROM eclipse-temurin:17-jdk-alpine
WORKDIR /workspace
COPY . .
RUN ./gradlew clean bootJar
ENTRYPOINT ["java", "-XX:+UseZGC", "-Xms64m", "-Xmx64m", "-jar", "/workspace/build/libs/korean-romanizer-web-1.0.0.jar"]
