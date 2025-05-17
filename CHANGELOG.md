# Changelog

Todas as mudanças importantes neste projeto serão documentadas aqui.

O formato segue as convenções do [Keep a Changelog](https://keepachangelog.com/pt-BR/1.0.0/), e este projeto segue [SemVer](https://semver.org/lang/pt-BR/).

---

## [1.0.0] - 2025-05-15

### Adicionado
- Integração com RabbitMQ usando a imagem `rabbitmq:3-management`.
- Configuração do `docker-compose.yml` com serviços para o `rabbitmq` e `springboot-app`.
- Criação do arquivo `application.yml` com propriedades para conexão RabbitMQ.
- Criação do container Spring Boot com suporte a envio e recebimento de mensagens AMQP.
- Dockerfile configurado para build de aplicação Spring Boot com JDK 17.
- Exposição das portas 8080, 5672 e 15672 para comunicação entre containers e acesso ao painel RabbitMQ.
- Rota HTTP (REST) para envio de mensagens para a fila.

### Corrigido
- Problema de DNS no WSL2 impedindo resolução de nomes e acesso ao Docker Hub.
- Conexão recusada entre aplicação e RabbitMQ ajustando o `host: rabbitmq` no `application.yml`.
- Problema ao instalar utilitários (como `ping`) dentro do container devido à falha de DNS.

### Removido
- Arquivo `application.properties` substituído completamente por `application.yml`.

---

