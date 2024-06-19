FROM openjdk:17
EXPOSE 8081
WORKDIR /app
COPY target/ADSDentalSurgeries-1.0-SNAPSHOT.jar /app/mydemo.jar
ENTRYPOINT ["java", "-jar", "mydemo.jar"]