
# Plataforma de Eventos Culturais e de Lazer - Centro do Recife

## Objetivo do Projeto

Desenvolver uma API para ajudar a sanar a dor da falta de eventos culturais e de lazer frequentes, especialmente no período noturno, no Centro do Recife, contribuindo para a revitalização do espaço e atração de moradores, turistas e comerciantes.

## Requisitos Cumpridos

- **Endpoints REST**:  
  - POST para criação de eventos  
  - GET por parâmetro diferente do ID (ex: busca por nome ou data)  
  - PUT para atualização  
  - DELETE para remoção  

- **Autenticação JWT** (implementação opcional e configurada)

- **Banco de Dados SQL** com pelo menos duas tabelas de domínio (ex: Evento e Local)

- **Tratamento de exceções** com mensagens padronizadas para cliente

- **Regras de negócio** implementadas na camada Service, sem acesso direto do Controller ao Repository

- **Separação em camadas**: Controller, Service e Repository

- **Logs** configurados para acompanhar execução e erros

- **DTOs** com validação dos campos (usando `javax.validation`)

- **Testes unitários** para serviços e controladores básicos

- **Documentação Swagger** (com problema conhecido a ser corrigido)

- **Estrutura do projeto**:  
  `src/main/java/br/recife/recentro/eventos_culturais/`

## Estrutura resumida do projeto

```
br.recife.recentro.eventos_culturais
│
├── controller
│   └── EventoController.java
├── service
│   └── EventoService.java
├── repository
│   └── EventoRepository.java
├── model
│   ├── EventoEntity.java
│   └── LocalEntity.java
├── dto
│   └── EventoDto.java
├── exception
│   └── GlobalExceptionHandler.java
├── security
│   └── JwtTokenProvider.java
│   └── SecurityConfig.java
└── Application.java
```

## Como rodar

1. Configure banco MySQL e `application.properties`
2. Rode com Maven:  
   ```bash
   mvn clean spring-boot:run
   ```  
3. Acesse a API pelo endpoint padrão (`http://localhost:8080/api/eventos`)  
4. A documentação Swagger deveria estar em `http://localhost:8080/swagger-ui.html` (erro atual devido a incompatibilidade de versões)

## Erro conhecido

A documentação Swagger apresenta falha por conta de uma incompatibilidade entre o Spring Boot 3.5.0 e a versão do springdoc-openapi (2.2.0). O erro aparece no log como `NoSuchMethodError` relacionado a `ControllerAdviceBean`. A correção será feita em futuras atualizações.

---

