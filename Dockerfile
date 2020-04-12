FROM openjdk:8-jdk-alpine
VOLUME C:\\Users\adity\\workspace
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]