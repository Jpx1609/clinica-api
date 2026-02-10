# 🏥 Sistema de Gestão de Clínica (API REST)

Este projeto é uma API RESTful desenvolvida para o gerenciamento de pacientes de uma clínica de psicologia. Foi criado com o objetivo de aplicar conceitos fundamentais do ecossistema **Java Spring Boot**, como persistência de dados, injeção de dependências e mapeamento objeto-relacional (ORM).

## 🛠️ Tecnologias Utilizadas

* **Java 17/21**: Linguagem base do projeto.
* **Spring Boot**: Framework para agilizar o desenvolvimento.
* **Spring Data JPA**: Para abstração da camada de persistência.
* **H2 Database**: Banco de dados em memória utilizado para testes e desenvolvimento ágil.
* **Lombok**: Para redução de código boilerplate (Getters/Setters).
* **Maven**: Gerenciador de dependências e build.

## 🏗️ Arquitetura do Projeto

O sistema segue o padrão de camadas para garantir a separação de responsabilidades:

1.  **Model/Entity**: Representação da tabela `Paciente` no banco de dados.
2.  **Repository**: Interface que utiliza Spring Data JPA para operações de CRUD.
3.  **Controller**: Camada de exposição dos endpoints REST da API.

## 🚀 Como Executar o Projeto

1.  Clone o repositório:
    `git clone https://github.com/seu-usuario/clinica-api.git`
2.  Abra o projeto no **IntelliJ IDEA**.
3.  Aguarde o Maven baixar as dependências.
4.  Execute a classe `ClinicaApiApplication`.
5.  A API estará disponível em `http://localhost:8080`.

## 🛣️ Endpoints Disponíveis

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/pacientes` | Lista todos os pacientes cadastrados. |
| **POST** | `/pacientes` | Cadastra um novo paciente enviando um JSON no corpo da requisição. |

### Exemplo de JSON para Cadastro (POST):
```json
{
  "nome": "João Pedro",
  "cpf": "123.456.789-00",
  "email": "joao@email.com"
}
