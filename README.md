# Spring Boot RabbitMQ Demo

Este é um projeto de exemplo usando Spring Boot 3 e RabbitMQ para enviar e consumir mensagens de forma simples.
Não foram feitos testes de unidade, pois o projeto é só para mostrar como funciona o RabbitMQ.
Foi optado usar o WSl2 no Windows para executar o projeo pois, o Docker Engine é mais leve do que o Docker Desktop.
---

## Funcionalidades

- Envio de mensagens para uma fila RabbitMQ via endpoint REST `POST /mensagens`
- Consumo das mensagens via `@RabbitListener` e exibição no console da sua IDE ( IntelliJ usado)
- Exemplo básico para entender mensageria com RabbitMQ

---

## Tecnologias usadas

- Java 17
- Spring Boot 3
- RabbitMQ
- Docker & Docker Compose

---

## 1. Rodando o RabbitMQ com Docker Compose

No diretório raiz do projeto, você deve ter um arquivo `docker-compose.yml` com o seguinte conteúdo:

```yaml
version: '3.8'
services:
  rabbitmq:
    image: rabbitmq:3-management
    ports:
      - "5672:5672"   # Porta AMQP
      - "15672:15672" # Porta do painel web RabbitMQ
    volumes:
      - rabbitmq-data:/var/lib/rabbitmq
volumes:
  rabbitmq-data:

```

## 2. pra subir o projeto no docker
- usado o docker engine pelo windows ( WSL2)
- vá para o diretorio na raiz do projeto
```bash
docker compose up -d
```
- para ver se o processo rodou 
```bash
 docker ps
```
- Você deve ver algo como:
```
NAME            IMAGE                    STATE   PORTS
rabbitmq-local  rabbitmq:3-management    Up      0.0.0.0:5672->5672/tcp, 0.0.0.0:15672->15672/tcp
```
---

## 3. Próximos passos rápidos com Docker Compose

| Passo                  | Comando                          | Para quê?                                      |
|------------------------|---------------------------------|------------------------------------------------|
| Ver logs em tempo real  | `docker compose logs -f rabbitmq` | Monitorar mensagens ou eventuais erros.        |
| Parar o container       | `docker compose stop`            | Para o container, mas mantém dados e volumes.  |
| Derrubar e remover tudo | `docker compose down`            | Remove container, rede, volumes e rede criados.|



### Exemplos no terminal

Ver logs em tempo real:

```bash
docker compose logs -f rabbitmq
```
- Enviar mensagem para Fila do RabbitMQ, pelo postman ou terminal

```
curl -X POST http://localhost:8080/mensagens \
  -H "Content-Type: application/json" \
  -d '{"conteudo":"Olá, RabbitMQ!","remetente":"Você"}'
```
