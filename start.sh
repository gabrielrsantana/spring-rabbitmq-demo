#!/bin/bash

echo "🔨 Gerando JAR com Maven..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
  echo "❌ Erro ao gerar o JAR. Abortando."
  exit 1
fi

echo "🐳 Subindo containers com Docker Compose..."
docker compose -f infra/docker-compose.yml up --build -d

if [ $? -eq 0 ]; then
  echo "✅ Projeto rodando! Acesse:"
  echo "→ Spring Boot: http://localhost:8080"
  echo "→ RabbitMQ Admin: http://localhost:15672 (guest/guest)"
else
  echo "❌ Falha ao subir os containers."
fi
