FROM openjdk:21
WORKDIR /app
COPY target/Spring-Boot-App-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "Spring-Boot-App-0.0.1-SNAPSHOT.jar"]
