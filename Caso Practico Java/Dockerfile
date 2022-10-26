FROM maven:3.6.0-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11

COPY --from=build /home/app/target/caso-practico-1.0-SNAPSHOT.jar /usr/local/lib/caso-practico.jar

ENTRYPOINT ["java", "-jar","/usr/local/lib/caso-practico.jar"]

EXPOSE 8081