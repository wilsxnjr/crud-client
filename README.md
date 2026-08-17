# CRUD Client

CRUD de clientes (`Client`) é um projecto desenvolvido em Spring Boot com o objectivo de praticar os meus conhecimentos de back-end com Java.

## Tecnologias

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC (`spring-boot-starter-webmvc`)
- Spring Data JPA
- H2 Database (`spring-boot-h2console`)
- Maven

## Sobre o projeto

A aplicação implementa operações básicas de um CRUD (create, retrieve, update e delete) sobre a entidade **Client**, utilizando Spring Data JPA para persistência e H2 como banco de dados.

## Arquitectura usada

<img width="1115" height="762" alt="Screenshot from 2026-08-15 09-27-50" src="https://github.com/user-attachments/assets/429096e5-55a7-44c0-b6e6-16d08ded2175" />

- Controllers - recebem as requisições HTTP e comunicam-se com a camada de serviço através de DTOs
- Services - contêm a lógica de negócio da aplicação
- Repositories - responsáveis pelo acesso e persistência dos dados
- Entities - representam as tabelas do banco de dados

## Endpoints da API
| Método | Endpoint      | Descrição            |
|:-------|:--------------|:---------------------|
| GET    | /clients      | Lista todos clientes |
| GET | /clients/{id} | Lista client por id  |
| POST | /client       | Criar cliente |
| PUT | /client/{id}  | Actualizar cliente |
| DELETE | /client/{id}  | Apagar cliente |



## Exemplo do PUT/POST
```json
{
  "name": "John Doe",
  "identityCard": "123456789W",
  "income": 100000.0,
  "birthDate": "2000-10-10T14:30:00Z",
  "children": 1
}
```
---

Projecto desenvolvido por **Wilson Jaime Machava Júnior**.
