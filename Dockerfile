#base pagage above
FROM openjdk:17
WORKDIR /app
COPY target/ADSDentalSurgeries-0.0.1-SNAPSHOT.jar /app/app.jar

#run the file
ENTRYPOINT ["java","-jar","app.jar"]