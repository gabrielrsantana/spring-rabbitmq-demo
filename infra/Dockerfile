# Usa imagem base com JDK 17
FROM eclipse-temurin:17-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o jar do projeto para o container
COPY target/*.jar app.jar

# Expõe a porta usada pelo Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
