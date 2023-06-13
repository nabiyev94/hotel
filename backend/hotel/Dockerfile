
FROM openjdk:11
EXPOSE 8080
ADD target/hotel-0.0.1-SNAPSHOT.jar hotel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev" ,"hotel-0.0.1-SNAPSHOT.jar"]

#FROM maven:3.8-jdk-11
#WORKDIR /hotel
#COPY . .
#EXPOSE 8080
#CMD ["mvn", "spring-boot:run"]