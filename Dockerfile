# imagem OpenJdk
FROM eclipse-temurin:17-jdk-alpine
# define o diretório de trabalho dentro do conteiner
WORKDIR /app

COPY pom.xml .
# copia o JAR da aplicação para o conteiner
COPY target/*.jar app.jar
# porta da aplicação
EXPOSE 8080
# inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

