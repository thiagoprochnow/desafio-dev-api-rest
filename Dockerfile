FROM openjdk:11

MAINTAINER thiprochnow@gmail.com

COPY target/desafio-dev-api-rest-0.0.1-SNAPSHOT.jar desafio-dev-api-rest.jar

ENTRYPOINT ["java","-jar","/desafio-dev-api-rest.jar"]