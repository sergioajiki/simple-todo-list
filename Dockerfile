
FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:17-jdk-slim

WORKDIR /usr/src/app
# porta da aplicação
EXPOSE 8080

COPY --from=build target/simple-todo-list*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
#adoptopenjdk:17-jdk-hotspot-bionic
#FROM adoptopenjdk:17-jdk-hotspot-bionic
#FROM eclipse-temurin:17-jdk-alpine
# define o diretório de trabalho dentro do conteiner

#COPY pom.xml .
# copia o JAR da aplicação para o conteiner
#COPY target/*.jar app.jar
# porta da aplicação
#EXPOSE 8080
# inicia a aplicação
#ENTRYPOINT ["java", "-jar", "app.jar"]

