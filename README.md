# Desafio Prático Backend Java

API REST para gerenciamento de tarefas, desenvolvida com Spring Boot, Java 21 e JPA. O projeto inclui suporte para PostgreSQL em ambiente real e H2 para desenvolvimento/testes locais.

## Tecnologias
- Java 21
- Spring Boot 3.3.2
- Maven
- PostgreSQL
- H2 Database
- Spring Data JPA
- Springdoc OpenAPI / Swagger

## Pré-requisitos
- JDK 21 instalado
- Maven 3.9+ ou usar o wrapper do projeto (`./mvnw`)
- PostgreSQL (para execução com banco real)
- Opcional: banco H2 para testes locais

## Clonando o projeto
```
git clone <url-do-repositorio>
cd DesafioPraticoBackEndJava
```
## Compilando o projeto
```
./mvnw clean install
```
##  Executando a aplicação

Opção 1: PostgreSQL (configuração padrão)
O projeto já está preparado para usar PostgreSQL no arquivo src/main/resources/application.properties.
Exemplo de configuração:
spring.application.name=DesafioPraticoBackEndJava

spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

Crie o banco no PostgreSQL:

CREATE DATABASE taskdb;

Execute a aplicação:
```
./mvnw spring-boot:run
```
A API ficará disponível em:

- http://localhost:8080

Swagger/OpenAPI:

- http://localhost:8080/swagger-ui/index.html

## Opção 2: H2 (para desenvolvimento/testes)

Para usar o H2 em memória, basta configurar o arquivo application.properties com a seguinte configuração:

spring.application.name=DesafioPraticoBackEndJava
spring.datasource.url=jdbc:h2:mem:taskdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

Execute:

```
./mvnw spring-boot:run
```
A console do H2 fica em:

- http://localhost:8080/h2-console

Observação: o H2 é ideal para testes e ambiente local. Para deploy real ou ambiente de produção, prefira PostgreSQL.

## Deploy da aplicação
 Build do projeto

```
./mvnw clean package
```
Isso gera o arquivo JAR em:
```
target/DesafioPraticoBackEndJava-0.0.1-SNAPSHOT.jar
```
Executando o JAR
```
java -jar target/DesafioPraticoBackEndJava-0.0.1-SNAPSHOT.jar
```
Deploy com variáveis de ambiente

Em ambientes de nuvem ou servidores, normalmente é melhor configurar as credenciais via variáveis de ambiente:
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/taskdb
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=sua_senha
export SPRING_JPA_HIBERNATE_DDL_AUTO=update

Depois:
```
./mvnw spring-boot:run
```
### Endpoints principais

A aplicação expõe endpoints REST para:

- /tasks
- /users
- /subtasks

A documentação interativa do Swagger pode ser acessada em:

- http://localhost:8080/swagger-ui/index.html
 
## Observações

- Para produção, utilize PostgreSQL e variáveis de ambiente para armazenar secrets.
- O H2 é recomendado apenas para desenvolvimento, testes locais e demos.
- O projeto usa ddl-auto=update, o que facilita o desenvolvimento inicial, mas para ambientes de produção pode ser necessário revisar a estratégia de migração do banco.
