# Sistematizacao_POO_01_2024_CEUB
Sistematização de POO do semestre 01/2024 - CEUB

Sistema de Cartões Médicos - Empresa Max Global Sports (MGS)

Este repositório contém o código-fonte do Sistema de Cartões Médicos desenvolvido para a empresa MGS. A aplicação foi construída com Spring Boot e PostgreSQL. Permite gerenciar algumas informações dos funcionários da empresa incluindo CPF, nome, data de nascimento, problemas médicos, telefone, etc.

Pré-requisitos:
Instalar os seguintes programas:

Java JDK 11 ou superior
Maven
PostgreSQL
Postman para execução dos comandos
Um editor de código como o Eclipse ou Visual Studio Code, para visualizar e executar o script.

Adeque o arquivo src/main/resources/application.properties com as credenciais do seu banco de dados no PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5433/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha


Para executar a aplicação:

Baixe e importe todo o diretorio Sistematizacao_POO_01_2024_CEUB-main para Eclipse ou outro editor de código.
Após a importação, abra o arquivo CartoesMgsApplication.java que se encontra neste diretório: 

/Sistematizacao_POO_01_2024_CEUB-main/Cartoes_MGS/src/main/java/Sistematizacao/Cartoes_MGS/CartoesMgsApplication.java

Execute a aplicação pelo Eclipse.

Abrir o Postman e escolher alguma das ações abaixo:

POST /http://localhost:8080/cartoes: Cadastra um novo cartão de funcionário

GET /http://localhost:8080/cartoes: Lista todos os cartões de funcionários cadastrados

GET /http://localhost:8080/cartoes/{id}: Mostra o cartão de um funcionário específico com base no id 

PUT /http://localhost:8080/cartoes/{id}: Atualiza os dados de um funcionário específico com base no id 

DELETE /http://localhost:8080/cartoes/{id}: Remove um funcionário específico com base no id do sistema
