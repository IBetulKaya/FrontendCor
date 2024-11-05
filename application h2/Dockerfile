# Use image: Linux and Java
FROM alpine/java:22-jdk

# Copy application to container
COPY target/app.jar /app.jar

# start application
ENTRYPOINT ["java","-jar","/app.jar"]
