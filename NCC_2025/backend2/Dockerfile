# Use OpenJDK 17 Alpine image
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
