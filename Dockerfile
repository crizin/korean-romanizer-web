FROM eclipse-temurin:17-jdk-alpine
CMD ["./gradlew", "bootJar"]
COPY build/libs/korean-romanizer-web-1.0.0.jar /app/korean-romanizer-web-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/app/korean-romanizer-web-1.0.0.jar"]
