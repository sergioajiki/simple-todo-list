# Estágio de construção usando a imagem base Ubuntu
FROM ubuntu:latest AS build
# Atualiza os pacotes do sistema
RUN apt-get update
# Instala o JDK 17
RUN apt-get install openjdk-17-jdk -y
# Copia todos os arquivos do contexto do build para o conteiner
COPY . .
# Instala o Maven
RUN apt-get install maven -y
# Compila a aplicação usando o Maven
RUN mvn clean install
# Segundo estágio usando uma imagem OpenJDK menor
FROM openjdk:17-jdk-slim
# define o diretório de trabalho dentro do conteiner
WORKDIR /usr/src/app
# porta da aplicação
EXPOSE 8080
# Copia o JAR da aplicação do estágio de construção para o conteiner
COPY --from=build target/simple-todo-list*.jar app.jar
# Define o comando de entrada para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]


