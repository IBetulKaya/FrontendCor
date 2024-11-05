# Use image: Linux and Java
FROM alpine/java:22-jdk

# Copy application to container
COPY target/app.jar /app.jar

# Copy application.properties to container (Remove from jar)
COPY target/application.properties /application.properties
COPY target/messages.properties /messages.properties
COPY target/messages_zh.properties /messages_zh.properties

# Start application
ENTRYPOINT ["java","-jar","/app.jar"]
